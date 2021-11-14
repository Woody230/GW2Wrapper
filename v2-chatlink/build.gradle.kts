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
        extSerialization()
        extFunction()
        extBase64()
    }
    commonTest()
    jvmTest()
}