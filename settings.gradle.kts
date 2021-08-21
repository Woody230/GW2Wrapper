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
                useModule("com.android.tools.build:gradle:4.0.1")
            }
        }
    }
}
rootProject.name = "GW2Wrapper"
include("v2-model")
include("v2-model-enumeration")
include("v2-client")
include("v2-chatlink")
include("v2-scope")
include("v2-scope-processor")
