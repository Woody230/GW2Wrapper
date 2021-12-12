plugins {
    kotlin("multiplatform")
    id("com.android.library")
    kotlin("plugin.serialization")
}

publishing.publish(project)

android.setup()

kotlin.setup {
    commonMain {
        v2Scope()
        ktxSerialization()
        ktxDateTime()
        extSerialization()
        extDateTime()
    }
    commonTest()
}