plugins {
    // TODO extension for plugins
    kotlin("multiplatform")
    id("com.android.library")
    kotlin("plugin.serialization")
}

android.setup()

kotlin.setup {
    commonMain {
        v2Scope()
    }
    commonTest()
}