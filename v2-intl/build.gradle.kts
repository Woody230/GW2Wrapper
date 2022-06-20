plugins {
    kotlin("multiplatform")
    id("com.android.library")
    kotlin("plugin.serialization") version Versions.KOTLIN
}

publishing.publish(
    project = project,
    description = "Internalization support by mapping translations from Guild Wars 2 API models."
)

android.setup()

kotlin.setup {
    commonMain {
        ktxSerialization()
        v2Client()
        ktorClient()
        coroutine()
        extFunction()
    }
    commonTest {
        mockKtorClient()
        v2Client()
    }
    jvmTest {
        jvmTest()
        jvmKtorClient()
    }
}