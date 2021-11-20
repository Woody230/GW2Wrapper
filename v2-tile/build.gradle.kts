plugins {
    kotlin("multiplatform")
    id("com.android.library")
    kotlin("plugin.serialization")
}

android.setup()

kotlin.setup {
    commonMain {
        v2Client()
        ktxSerialization()
        ktorClient()
        coroutine()
    }
    commonTest {
        mockKtorClient()
    }
    jvmTest {
        jvmTest()
        jvmKtorClient()
    }
}