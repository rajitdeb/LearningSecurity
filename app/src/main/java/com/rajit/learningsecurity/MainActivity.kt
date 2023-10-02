package com.rajit.learningsecurity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         * This is how we secure our API_KEY from getting upload in VCS
         * STEPS:
         * 0. Mention the local.properties file in .gitignore file
         * 1. Setting buildConfig to true under buildFeatures block
         * 2. Pasting the API_KEY in local.properties file like so: apiKey = THIS_IS_A_SENSITIVE_API_KEY
         * 3. Creating a Properties object accessing the API_KEY field from local.properties:
         *      LIKE SO:
         *          val properties = Properties()
         *         properties.load(project.rootProject.file("local.properties").inputStream())
         *
         *         buildConfigField("String", "API_KEY", "\"${properties.getProperty("apiKey")}\"")
         *
         * 4. Rebuild the project
         * 5. Then access the API_KEY with the following code:
         *      val apiKey = BuildConfig.API_KEY
         *
         * 6. DONE
         *
         * PRO TIP:
         * Enable R8/Proguard and set minifyEnabled to True in order to prevent Reverse Engineering (for the release build)
         *
         */
        val apiKey = BuildConfig.API_KEY

        Toast.makeText(
            applicationContext,
            "ApiKey: $apiKey",
            Toast.LENGTH_SHORT
        ).show()

        /**
         * In order to completely keep your API_KEY secured, keep them in the server
         * and make the accessing code server sided
         *
         * NOTE:
         * No code is fool-proof and can be reverse-engineered but we can definitely prevent
         * it to a large extent.
         */

    }
}