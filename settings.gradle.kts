plugins {
    // See https://jmfayard.github.io/refreshVersions
    id("de.fayard.refreshVersions") version "0.23.0"
}

rootProject.name = "Template"

include("Commons_Android:gradle", "app")
