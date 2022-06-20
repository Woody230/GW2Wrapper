plugins {
    kotlin("multiplatform")
    id("com.android.library")
    kotlin("plugin.serialization") version Versions.KOTLIN
}

publishing.publish(
    project = project,
    description = "Annotations for permissions required to access Guild Wars 2 API endpoints."
)

android.setup()

kotlin.setup {
    commonMain {
        ktxSerialization()
    }
    commonTest()
}