plugins {
    kotlin("multiplatform")
    id("com.android.library")
    kotlin("plugin.serialization") version Versions.KOTLIN
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = Metadata.JVM_TARGET
}

allprojects {
    group = Metadata.GROUP_ID
    version = Metadata.VERSION

    apply(plugin = "maven-publish")
    apply(plugin = "signing")

    repositories {
        google()
        mavenCentral()
        mavenLocal()
        maven("https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/")
        maven("https://s01.oss.sonatype.org/content/repositories/snapshots/")
    }
}

android.setup(manifestPath = "buildSrc/src/androidMain/AndroidManifest.xml")
kotlin.setup()