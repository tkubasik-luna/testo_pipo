// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {

    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath(Android.tools.build.gradlePlugin)
        classpath(libs.kotlin.gradle.plugin)
    }
}

allprojects {
    repositories {
        maven {
            url = uri("https://s01.oss.sonatype.org/content/repositories/snapshots/")
        }
        maven {
            url = uri("https://androidx.dev/storage/compose-compiler/repository/")
        }
    }
}

plugins {
    id("io.gitlab.arturbosch.detekt")
}

apply("Commons_Android/gradle/pr-code-analysis-project.gradle")

tasks.withType<io.gitlab.arturbosch.detekt.Detekt> {
    exclude("**/build/**")
}

detekt {
    config = files("$projectDir/Commons_Android/lunabee-detekt-config.yml", "$projectDir/project-detekt-config.yml")
}

apply("Commons_Android/gradle/lunabee-root.gradle.kts")