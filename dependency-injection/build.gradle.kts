plugins {
    `android-library`
}

android {
    namespace = "studio.lunabee.immortalgaming.dependencyinjection"
}

dependencies {
    implementation(project(":domain"))
    implementation(project(":repository"))
    implementation(project(":local-android"))
    implementation(project(":remote"))
}
