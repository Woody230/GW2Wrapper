plugins {
    kotlin("multiplatform")
    id("com.android.library")
    kotlin("plugin.serialization")
}

android.setup()

kotlin.setup {
    commonMain {
        v2Scope()
        ktxSerialization()
        ktxDateTime()
        personalKtxSerialization()
        personalKtxDateTime()
    }
    commonTest()
}