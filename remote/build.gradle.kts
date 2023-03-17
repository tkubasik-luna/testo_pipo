plugins {
    `kotlin-library`
}

dependencies {
    implementation(project(":repository"))
    implementation(project(":domain"))
    implementation(project(":error"))
}
