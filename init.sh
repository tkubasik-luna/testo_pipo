#!/bin/bash

BASE_DIR=$(dirname "$0")
APP_PACKAGE="$1"
APP_NAME="$2"

PACKAGE_DIR="$BASE_DIR/app/src/main/java/${APP_PACKAGE//.//}"

# Add Common_Android submodule
git -C "$BASE_DIR" submodule add --force git@github.com:LunabeeStudio/Commons_Android.git
git -C "$BASE_DIR" submodule update --init --recursive --remote

# Replace package name where needed
sed -i '' "s/com.lunabee.template.android/$APP_PACKAGE/g" "$BASE_DIR"/build.gradle.kts "$BASE_DIR"/app/src/main/AndroidManifest.xml \
  "$BASE_DIR"/app/src/main/java/com/lunabee/template/android/MainActivity.kt

# Replace app name where needed
sed -i '' "s/Template/$APP_NAME/g" "$BASE_DIR"/app/src/dev/res/values/appname_string.xml \
  "$BASE_DIR"/app/src/prod/res/values/appname_string.xml "$BASE_DIR"/settings.gradle.kts

# Create package dir and move default activity into it
mv "$BASE_DIR"/app/src/main/java/com/lunabee/template/android/MainActivity.kt "$BASE_DIR"
rm -Rf "$BASE_DIR"/app/src/main/java/com
mkdir -p "$PACKAGE_DIR"
mv "$BASE_DIR"/MainActivity.kt "$PACKAGE_DIR"

# Clear readme
echo "$APP_PACKAGE" >"$BASE_DIR"/README.md

# Refresh deps
./gradlew refreshVersionsMigrate
./gradlew refreshVersions

# Sync & build
./gradlew build -x lint

# Self delete init script
rm "$0"
