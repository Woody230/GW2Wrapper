plugins {
    kotlin("multiplatform") version "1.5.20"
    id("com.android.library")
    kotlin("plugin.serialization") version "1.5.20"
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

allprojects {
    group = "com.bselzer.library.gw2"
    version = "1.0.0"

    apply(plugin = "maven-publish")

    repositories {
        google()
        mavenCentral()
        maven { setUrl("https://jitpack.io") }
    }
}

kotlin {
    android {
        publishLibraryVariants("release", "debug")
    }
}

android {
    compileSdkVersion(30)
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdkVersion(23)
        targetSdkVersion(30)
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}