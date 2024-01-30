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

rootProject.name = "My Application Tester"
include(":app")
include(":QR-Barcode")
project(":QR-Barcode").projectDir = File(rootDir, "QR-Barcode/app")

 