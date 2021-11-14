plugins {
    kotlin("multiplatform")
    id("com.android.library")
    kotlin("plugin.serialization")
}

android.setup()

kotlin.setup {
    commonMain {
        v2Model()
        v2Scope()
        ktxSerialization()
        extSerialization()
        extFunction()
    }
    commonTest()
    jvmTest()
}