plugins {
    kotlin("multiplatform")
    id("com.android.library")
    kotlin("plugin.serialization") version KOTLIN
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

allprojects {
    group = "com.bselzer.gw2"
    version = "1.0.0"

    apply(plugin = "maven-publish")

    repositories {
        google()
        mavenCentral()
        maven { setUrl("https://jitpack.io") }
        mavenLocal()
    }
}

android.setup(manifestPath = "buildSrc/src/androidMain/AndroidManifest.xml")
kotlin.setup()