plugins {
    kotlin("multiplatform")
    id("com.android.library")
    kotlin("plugin.serialization") version Versions.KOTLIN
}

publishing.publish(
    project = project,
    description = "Guild emblem image fetching from https://emblem.werdes.net/"
)

android.setup()

kotlin.setup {
    commonMain {
        ktorClient()
        ktxSerialization()
    }
    commonTest()
    jvmTest {
        jvmTest()
        jvmKtorClient()
    }
}