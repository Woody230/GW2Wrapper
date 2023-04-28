plugins {
    kotlin("multiplatform")
    id("com.android.library")
    kotlin("plugin.serialization") version Versions.KOTLIN
}

publishing.publish(
    project = project,
    description = "Base64 Guild Wars 2 chat link encoding and decoding."
)

android.setup()

kotlin.setup {
    commonMain {
        v2Model()
        v2ModelEnumeration()
        ktxSerialization()
        extBase64()
        extFunction()
    }
    commonTest()
    jvmTest()
}