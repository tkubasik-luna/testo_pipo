plugins {
    id("com.android.application")
    id("kotlin-android")
}

version = AndroidConfig.envVersionName
group = ProjectConfig.GROUP_ID

android {
    flavorDimensions += "environment"
    productFlavors {
        create("dev") {
            dimension = "environment"
            applicationIdSuffix = ".dev"
            versionNameSuffix = "#${AndroidConfig.envVersionCode} dev"

            buildConfigField("Boolean", "IS_DEV", "true")
        }

        create("prod") {
            dimension = "environment"
            buildConfigField("Boolean", "IS_DEV", "false")
        }
    }

    compileOptions {
        sourceCompatibility = ProjectConfig.JDK_VERSION
        targetCompatibility = ProjectConfig.JDK_VERSION
    }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().all {
    kotlinOptions {
        jvmTarget = ProjectConfig.JDK_VERSION.toString()
    }
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(ProjectConfig.JDK_VERSION.toString()))
    }
}