plugins {
    kotlin("multiplatform")
    id("com.android.library")
    kotlin("plugin.serialization") version Versions.KOTLIN
}

publishing.publish(
    project = project,
    description = "Guild Wars 2 API models for v2-client."
)

android.setup(project)

kotlin.setup {
    commonMain {
        v2Scope()
        ktxSerialization()
        ktxDateTime()
        extSerialization()
        extDateTime()
        extValueIdentifier()
        extGeometry()
    }
    commonTest()
}