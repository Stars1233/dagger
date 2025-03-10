pluginManagement {
  repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
  }
}

dependencyResolutionManagement {
  repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
  repositories {
    google()
    mavenCentral()
  }
}

rootProject.name = "dagger-parent"

fun includeProject(name: String, path: String) {
  include(name)
  project(name).projectDir = File(path)
}

includeProject(":dagger", "dagger-runtime")

includeProject(":dagger-compiler", "dagger-compiler")

includeProject(":dagger-producers", "dagger-producers")

includeProject(":dagger-spi", "dagger-spi")

includeProject(":dagger-testing", "dagger-testing")
