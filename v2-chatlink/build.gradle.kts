plugins {
    kotlin("multiplatform")
    id("com.android.library")
    kotlin("plugin.serialization")
}

publishing.publish(project)

android.setup()

kotlin.setup {
    commonMain {
        v2Model()
        v2ModelEnumeration()
        ktxSerialization()
        extBase64()
    }
    commonTest()
    jvmTest()
}