plugins {
    kotlin("multiplatform")
    id("com.android.library")
    kotlin("plugin.serialization") version Versions.KOTLIN
}

publishing.publish(project)

android.setup()

kotlin.setup {
    commonMain {
        v2Model()
        v2ModelExtension()
        ktxSerialization()
        ktorClient()
        coroutine()
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