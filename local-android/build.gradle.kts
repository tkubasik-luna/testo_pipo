plugins {
    `android-library`
}

android {
    namespace = "com.lunabee.template.storage"
}

dependencies {
    implementation(project(":domain"))
    implementation(project(":repository"))
    implementation(project(":error"))
    androidTestImplementation(project(":dependency-injection:test-component"))
}