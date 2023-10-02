package com.rajit.learningsecurity.model

/**
 * This is a model class, which will be used by our API to map the JSON object to this class
 * Often, it happens while using Proguard/R8 that the code obfuscation makes the model classes unreadable
 * Thereby, increasing the chances of crash
 * So, we can annotate each data class with @keep annotation
 * or, declare the same in the proguard-rules.pro file
 */
data class SampleData(
    val name: String
)
