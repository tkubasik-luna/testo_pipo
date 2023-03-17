plugins {
    `application-flavors`
    id("kotlin-android")
}

apply(from = "../Commons_Android/gradle/pr-code-analysis-app.gradle")

android {
    namespace = "com.lunabee.template"

    compileSdk = AndroidConfig.COMPILE_SDK
    buildToolsVersion = AndroidConfig.BUILD_TOOLS_VERSION

    defaultConfig {
        minSdk = AndroidConfig.MIN_SDK
        targetSdk = AndroidConfig.TARGET_SDK

        versionCode = AndroidConfig.envVersionCode
        versionName = AndroidConfig.envVersionName

        vectorDrawables {
            useSupportLibrary = true
        }
    }

    signingConfigs {
        maybeCreate("dev").apply {
        }
        maybeCreate("releaseProd").apply {
        }
    }

    buildTypes {
        debug {
            // Uncomment the following line to use the flavor signing
            // signingConfig = null
            isMinifyEnabled = false
        }
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    kotlinOptions.freeCompilerArgs += "-opt-in=kotlin.RequiresOptIn"

    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "_"
    }
}

dependencies {
    implementation(Kotlin.stdlib.jdk8)
    implementation(AndroidX.appCompat)
    implementation(AndroidX.core.ktx)

    // Compose
    implementation(AndroidX.compose.ui)
    debugImplementation(AndroidX.compose.ui.tooling)
    implementation(AndroidX.compose.ui.toolingPreview)
    implementation(AndroidX.Activity.compose)
    implementation(AndroidX.compose.foundation)
    implementation(AndroidX.compose.material)


    implementation(project(":dependency-injection"))
    implementation(project(":domain"))
    implementation(project(":error"))

    androidTestImplementation(project(":dependency-injection:test-component"))
    androidTestImplementation(project(":local-android"))
    androidTestImplementation(project(":remote"))
    androidTestImplementation(project(":repository"))
}

apply(from = "../Commons_Android/gradle/lunabee-app.gradle.kts")
