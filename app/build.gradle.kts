plugins {
    `application-flavors`
}

apply(from = "../Commons_Android/gradle/pr-code-analysis-app.gradle")

android {

    compileSdk = AndroidConfig.COMPILE_SDK
    buildToolsVersion = AndroidConfig.BUILD_TOOLS_VERSION

    defaultConfig {
        minSdk = AndroidConfig.MIN_SDK
        targetSdk = AndroidConfig.TARGET_SDK

        versionCode = System.getenv(EnvConfig.ENV_VERSION_CODE)?.toInt() ?: AndroidConfig.VERSION_CODE
        versionName = System.getenv(EnvConfig.ENV_VERSION_NAME) ?: AndroidConfig.VERSION_NAME
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
            proguardFiles += getDefaultProguardFile("proguard-android-optimize.txt")
            proguardFiles += File("proguard-rules.pro")
        }
    }
}

dependencies {
    implementation(Kotlin.stdlib.jdk8)

    implementation(AndroidX.appCompat)
    implementation(AndroidX.core.ktx)

    implementation(Google.android.material)
}

apply(from = "../Commons_Android/gradle/lunabee-app.gradle.kts")
