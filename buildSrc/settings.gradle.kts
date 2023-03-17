pluginManagement {
    plugins {
        id("de.fayard.refreshVersions") version "0.51.0"
    }
}

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            from(files("../gradle/libs.versions.toml"))
        }
    }
}

plugins {
    id("de.fayard.refreshVersions")
}