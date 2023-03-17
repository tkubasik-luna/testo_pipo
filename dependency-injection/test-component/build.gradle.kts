plugins {
    `android-library`
}

android {
    namespace = "com.lunabee.template.dependencyinjection.test"
}

dependencies {
    implementation(project(":domain"))
    implementation(project(":repository"))
    implementation(project(":local-android"))
    implementation(project(":remote"))
    implementation(project(":dependency-injection"))
}