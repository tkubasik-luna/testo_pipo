# Android Application Lunabee Template
A base template to start a new Android project at Lunabee

## How to use it
1. Click on "Use this template" on the Github repo page to create a new repo.
2. Clone your new repo, do not open it in Android Studio.
3. From the project folder, run the initialization script: `sh ./init.sh package app_name` where:
   • `package` is the desired app package (ex: com.lunabee.myapp.android).
   • `app_name` is the desired app name (ex: My App)
This will clear this readme & remove the script itself.
4. Now you can open the project in Android Studio
5. Add a read-only Loco API key in `gradle.properties`
6. Set the application name in strings resources & dev AndroidManifest
7. Commit & push

## What does this template contain?
- Gradle's build files:
  - Root [`build.gradle`]: firebase app distribution, code analysis tools
  - [`submodulesChecks.gradle`]: groovy script which ensure that Commons_Android submodule is initialized
  - [`android.gradle`]: sdk versions, app id
  - [`versions.gradle`]: versions container with some defaults.
  - App [`build.gradle`]: app's dependencies + other gradle files import
  - [`devVersion.gradle`] & [`prodVersion.gradle`]: app versions (compliant with Bitrise flow)
  - [`flavors.gradle`]: flavor/buildType specific config
  - [`signing.gradle`]: placeholder for signings configs
  - [`settings.gradle`]: import of `submodulesChecks.gradle` to run it at initialization time
  - [`gradle.properties`]: defaults + LOCO_KEY placeholder
- Manifests: prod + dev (app name overridden)
- Empty [`MainActivity`] to make the application executable out of the box
- Defaults drawables and mipmaps

[`build.gradle`]:https://github.com/LunabeeStudio/ApplicationTemplate_Android/blob/master/build.gradle
[`submodulesChecks.gradle`]:https://github.com/LunabeeStudio/ApplicationTemplate_Android/blob/master/submoduleChecks.gradle
[`android.gradle`]:https://github.com/LunabeeStudio/ApplicationTemplate_Android/blob/master/android.gradle
[`versions.gradle`]:https://github.com/LunabeeStudio/ApplicationTemplate_Android/blob/master/versions.gradle
[`build.gradle`]:https://github.com/LunabeeStudio/ApplicationTemplate_Android/blob/master/app/build.gradle
[`devVersion.gradle`]:https://github.com/LunabeeStudio/ApplicationTemplate_Android/blob/master/app/devVersion.gradle
[`prodVersion.gradle`]:https://github.com/LunabeeStudio/ApplicationTemplate_Android/blob/master/app/prodVersion.gradle
[`flavors.gradle`]:https://github.com/LunabeeStudio/ApplicationTemplate_Android/blob/master/app/flavors.gradle
[`signing.gradle`]:https://github.com/LunabeeStudio/ApplicationTemplate_Android/blob/master/app/signing.gradle
[`settings.gradle`]:https://github.com/LunabeeStudio/ApplicationTemplate_Android/blob/master/settings.gradle
[`gradle.properties`]:https://github.com/LunabeeStudio/ApplicationTemplate_Android/blob/master/gradle.properties
[`MainActivity`]:https://github.com/LunabeeStudio/ApplicationTemplate_Android/blob/master/app/src/main/java/com/lunabee/template/android/MainActivity.kt
