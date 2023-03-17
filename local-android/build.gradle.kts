plugins {
    `android-library`
}

android {
    namespace = "studio.lunabee.immortalgaming.storage"
}

dependencies {
    implementation(project(":domain"))
    implementation(project(":repository"))
    implementation(project(":error"))
    androidTestImplementation(project(":dependency-injection:test-component"))
}