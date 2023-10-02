# LearningSecurity
This repository focuses on learning the security aspect of Android and how to secure API keys

# Steps to secure API Keys in Android
1. Mention the `local.properties` file in the .gitignore file
2. Setting `buildConfig` to true under `buildFeatures` block
3. Pasting the `API_KEY` in `local.properties` file like so: `apiKey = THIS_IS_A_SENSITIVE_API_KEY`
4. Creating a `Properties` object accessing the API_KEY field from `local.properties`:
    ```Kotlin
      val properties = Properties()
      properties.load(project.rootProject.file("local.properties").inputStream())
      buildConfigField("String", "API_KEY", "\"${properties.getProperty("apiKey")}\"")
    ```
5. Rebuild the project
6. Then access the API_KEY with the following code:
   
    ```Kotlin
      val apiKey = BuildConfig.API_KEY
    ```
7. Done

> [!NOTE]
> In order to completely keep your `API_KEY` secured, keep them in the server and make the accessing code server-sided

> [!NOTE]
> No code is fool-proof and can be reverse-engineered but we can definitely prevent it to a large extent

# Understanding Proguard rules
1. Enable R8/Proguard and set `minifyEnabled` to `true` in order to prevent Reverse Engineering (for the release build)
2. Set `shrinkResources` to `true` in order to reduce the file size of the release APK
3. Set `debuggable` to `false` in order to prevent your app to be easily debuggable by unauthorized users
4. Sometimes, it happens that with the usage of proguard, it performs Code Obfuscation on the classes that shouldn't be altered. For example, `model classes`
5. So, we add this code in the `proguard-rules.pro` file:
   
   ```Kotlin
    -keep class com.example.packagename.model.*
   ```
   Alternative approach to do this (applies to folders, sub-folders and its files):
   ```Kotlin
    -keep class com.example.packagename.model.**{*;}
   ```
> [!NOTE]
> Check & add Proguard rules for `every single dependency` (can be found in their respective `GitHub repo` under `Proguard` section) in your application before releasing the app. Or, while working in the project

