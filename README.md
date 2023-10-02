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
> Enable R8/Proguard and set `minifyEnabled` to `true` in order to prevent Reverse Engineering (for the release build)

> [!NOTE]
> In order to completely keep your `API_KEY` secured, keep them in the server and make the accessing code server-sided

> [!NOTE]
> No code is fool-proof and can be reverse-engineered but we can definitely prevent it to a large extent
