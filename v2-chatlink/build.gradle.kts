plugins {
    kotlin("multiplatform")
    id("com.android.library")
    kotlin("plugin.serialization")
}

android.setup()

kotlin.setup {
    commonMain {
        v2Model()
        ktxSerialization()
        personalKtxSerialization()
        personalKtxFunction()
        personalKtxBase64()
    }
    commonTest()
    jvmTest()
}