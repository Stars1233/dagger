/*
 * Copyright (C) 2025 The Dagger Authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dagger.gradle.build

import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.JavaPluginExtension
import org.gradle.jvm.toolchain.JavaLanguageVersion
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmProjectExtension
import org.jetbrains.kotlin.gradle.dsl.KotlinProjectExtension
import org.jetbrains.kotlin.gradle.dsl.KotlinVersion

/**
 * A convention plugin that sets the default configuration for JVM (Kotlin + Java) projects in
 * Dagger's codebase. Individual libraries can override these conventions if necessary.
 *
 * This plugin can be applied using:
 * ```
 * plugins {
 *   alias(libs.plugins.dagger.kotlinJvm)
 * }
 * ```
 *
 * Source sets for the project are configured by this plugin and should have the following
 * convention:
 * ```
 * <project>
 *   main
 *     java - Library sources
 *     resources - Library resources
 *   test
 *     javatests - Unit test sources
 *     resources - Unit test resources
 * ```
 */
class KotlinJvmConventionPlugin : Plugin<Project> {
  override fun apply(project: Project) {
    project.pluginManager.apply(project.getPluginIdByName("kotlinJvm"))
    project.plugins.withId(project.getPluginIdByName("kotlinJvm")) {
      configureSourceSets(project)
      val kotlinProject = project.extensions.getByName("kotlin") as KotlinJvmProjectExtension
      kotlinProject.jvmToolchain {
        languageVersion.set(JavaLanguageVersion.of(project.getVersionByName("jdk")))
      }
      kotlinProject.compilerOptions.apply {
        languageVersion.set(KotlinVersion.fromVersion(project.getVersionByName("kotlinTarget")))
        apiVersion.set(KotlinVersion.fromVersion(project.getVersionByName("kotlinTarget")))
        jvmTarget.set(JvmTarget.fromTarget(project.getVersionByName("jvmTarget")))
      }
      val javaProject = project.extensions.getByName("java") as JavaPluginExtension
      javaProject.sourceCompatibility = JavaVersion.toVersion(project.getVersionByName("jvmTarget"))
      javaProject.targetCompatibility = JavaVersion.toVersion(project.getVersionByName("jvmTarget"))
    }
  }

  private fun configureSourceSets(project: Project) {
    val kotlinExtension =
      project.extensions.findByType(KotlinProjectExtension::class.java)
        ?: error("Unable to find Kotlin Project Extension")
    val javaExtension =
      project.extensions.findByType(JavaPluginExtension::class.java)
        ?: error("Unable to find Java Project Extension")
    listOf("main", "test").forEach { name ->
      val rootSrcDir =
        when (name) {
          "main" -> "java"
          "test" -> "javatests"
          else -> error("Unknown source set named '$name'.")
        }
      kotlinExtension.sourceSets.named(name).configure {
        kotlin.srcDirs("$name/$rootSrcDir")
        resources.srcDirs("$name/resources")
      }
      javaExtension.sourceSets.named(name).configure { java.srcDirs("$name/$rootSrcDir") }
    }
  }
}
