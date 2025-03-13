import dagger.gradle.build.findXProcessingJar
import dagger.gradle.build.findXProcessingTestingJar

plugins { alias(libs.plugins.dagger.kotlinJvm) }

dependencies {
  implementation(project(":dagger"))
  implementation(project(":dagger-spi"))
  implementation(project(":dagger-compiler"))
  implementation(files(project.findXProcessingJar()))
  implementation(files(project.findXProcessingTestingJar()))
  implementation(libs.auto.value.annotations)
  annotationProcessor(libs.auto.value.compiler)
  implementation(libs.checkerFramework)
  implementation(libs.guava.jre)
  implementation(libs.javaCompileTesting)
  implementation(libs.javax.inject)
  implementation(libs.junit)
  implementation(libs.ksp.api)
  implementation(libs.truth)
}
