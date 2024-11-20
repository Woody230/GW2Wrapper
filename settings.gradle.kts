pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        mavenLocal()
    }
}

plugins {
    id("io.github.woody230.gradle.internal.bundled") version "1.7.0"
}

rootProject.name = "GW2Wrapper"
include("asset-cdn")
include("v2-chatlink")
include("v2-client")
include("v2-emblem")
include("v2-intl")
include("v2-model")
include("v2-model-enumeration")
include("v2-model-extension")
include("v2-resource")
include("v2-scope")
include("v2-tile-client")
include("v2-tile-model")
