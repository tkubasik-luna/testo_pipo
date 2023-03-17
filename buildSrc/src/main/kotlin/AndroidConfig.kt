object AndroidConfig {
    const val VERSION_CODE: Int = 1
    const val VERSION_NAME: String = "0.1.0"

    const val COMPILE_SDK: Int = 33
    const val TARGET_SDK: Int = COMPILE_SDK
    const val MIN_SDK: Int = 23
    const val BUILD_TOOLS_VERSION: String = "33.0.2"

    val envVersionCode: Int = System.getenv(EnvConfig.ENV_VERSION_CODE)?.toInt() ?: VERSION_CODE
    val envVersionName: String = System.getenv(EnvConfig.ENV_VERSION_NAME) ?: VERSION_NAME
}