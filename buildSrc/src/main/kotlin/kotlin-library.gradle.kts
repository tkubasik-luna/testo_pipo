plugins {
    id("java-library")
    id("kotlin")
}

version = AndroidConfig.envVersionName
group = ProjectConfig.GROUP_ID

dependencies {}

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