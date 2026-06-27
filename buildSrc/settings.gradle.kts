pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

plugins {
    // TODO https://github.com/gradle/gradle/issues/15383
    // https://github.com/radoslaw-panuszewski/typesafe-conventions-gradle-plugin
    id("dev.panuszewski.typesafe-conventions") version "0.11.1"
}