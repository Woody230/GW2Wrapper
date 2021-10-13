pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
    resolutionStrategy {
        eachPlugin {
            if (requested.id.namespace == "com.android" || requested.id.name == "kotlin-android-extensions")
            {
                useModule("com.android.tools.build:gradle:4.2.0")
            } else if (requested.id.id == "com.squareup.sqldelight")
            {
                useModule("com.squareup.sqldelight:gradle-plugin:1.5.1")
            }
        }
    }
}
rootProject.name = "GW2Wrapper"
include("v2-model")
include("v2-model-enumeration")
include("v2-model-extension")
include("v2-client")
include("v2-chatlink")
include("v2-scope")
include("v2-scope-processor")
include("v2-database")
include("v2-tile")