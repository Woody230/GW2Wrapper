plugins {
    kotlin("multiplatform")
    id("com.android.library")
    kotlin("plugin.serialization")
}

android.setup()

kotlin.setup {
    commonMain {
        ktxSerialization()
        extBase64()
    }
    commonTest()
    jvmTest()
}