plugins {
    kotlin("multiplatform")
    id("com.android.library")
    kotlin("plugin.serialization") version Versions.KOTLIN
}

publishing.publish(
    project = project,
    description = "Enumerations for Guild Wars 2 API models."
)

android.setup(project)

kotlin.setup {
    commonMain {
        v2Model()
        ktxSerialization()
        extSerialization()
    }
    commonTest()
    jvmTest()
}