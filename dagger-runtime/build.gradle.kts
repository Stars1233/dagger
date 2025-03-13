plugins {
  alias(libs.plugins.dagger.kotlinJvm)
  alias(libs.plugins.dagger.publish)
  alias(libs.plugins.binaryCompatibilityValidator)
}

dependencies {
  api(libs.javax.inject)
  api(libs.jakarta.inject)
  api(libs.jspecify)

  testImplementation(libs.junit)
  testImplementation(libs.truth)
  testImplementation(libs.guava.jre)
}

kotlin { explicitApi() }
