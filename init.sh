#!/bin/zsh

BASE_DIR=$(dirname "$0")
APP_PACKAGE="$1"
APP_NAME="$2"

find . -type d -empty -delete

# Add Common_Android submodule
git -C "$BASE_DIR" submodule add --force git@github.com:LunabeeStudio/Commons_Android.git
git -C "$BASE_DIR" submodule update --init --recursive --remote

# Replace package name where needed
find . -type f -name '*.kt' -exec sed -i '' s/com.lunabee.template/"${APP_PACKAGE}"/g {} +
find . -type f -name '*.kts' -exec sed -i '' s/com.lunabee.template/"${APP_PACKAGE}"/g {} +

# Replace app name where needed
sed -i '' "s/Template/$APP_NAME/g" "$BASE_DIR"/app/src/dev/res/values/appname_string.xml \
  "$BASE_DIR"/app/src/prod/res/values/appname_string.xml "$BASE_DIR"/settings.gradle.kts

INDEX_ARRAY=("template" "lunabee" "com")

IFS='.' read -ra ADDR <<<"$APP_PACKAGE"
revlist=
for i in "${ADDR[@]}"; do
  revlist="$i $revlist"
done

index=0
for i in $revlist; do
  echo "${INDEX_ARRAY[index]} -> $i"
  find . -depth -type d -name "${INDEX_ARRAY[index]}" -execdir mv {} "$i" \;
  index=$((index + 1))
done

# Clear readme
echo "$APP_PACKAGE" >"$BASE_DIR"/README.md

# Refresh deps
./gradlew refreshVersionsMigrate
./gradlew refreshVersions

# Sync & build
./gradlew build -x lint

# Self delete init script
rm "$0"
