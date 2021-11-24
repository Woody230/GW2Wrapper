plugins {
    kotlin("multiplatform")
    id("com.android.library")
    kotlin("plugin.serialization")
}

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