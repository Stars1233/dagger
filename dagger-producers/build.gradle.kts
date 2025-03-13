plugins {
  alias(libs.plugins.dagger.kotlinJvm)
  alias(libs.plugins.dagger.publish)
}

dependencies {
  api(project(":dagger"))
  implementation(libs.checkerFramework)
  implementation(libs.guava.jre)
}

kotlin { explicitApi() }
