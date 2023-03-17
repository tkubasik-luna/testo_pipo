pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}


plugins {
    // See https://jmfayard.github.io/refreshVersions
    id("de.fayard.refreshVersions") version "0.51.0"
}

refreshVersions {
    featureFlags {
        enable(de.fayard.refreshVersions.core.FeatureFlag.LIBS)
    }
}

rootProject.name = "Template"

include(":Commons_Android")
project(":Commons_Android").projectDir = File("Commons_Android/gradle")
include(":app")
include(":domain")
include(":repository")
include(":remote")
include(":local-android")
include(":error")
include(":dependency-injection")
include(":dependency-injection:test-component")

