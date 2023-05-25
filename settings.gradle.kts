pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
        mavenLocal()
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version ("0.4.0")
}

// TODO feature preview https://docs.gradle.org/8.1.1/userguide/declaring_dependencies.html#sec:type-safe-project-accessors
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

rootProject.name = "GW2Wrapper"
include("asset-cdn")
include("v2-chatlink")
include("v2-client")
include("v2-emblem")
include("v2-intl")
include("v2-intl-kodein-db")
include("v2-model")
include("v2-model-enumeration")
include("v2-model-extension")
include("v2-model-kodein-db")
include("v2-resource")
include("v2-scope")
include("v2-tile-client")
include("v2-tile-kodein-db")
include("v2-tile-model")
