plugins {
    kotlin("multiplatform")
    id("com.android.library")
    kotlin("plugin.serialization")
}

publishing.publish(project)

android.setup()

kotlin.setup {
    commonMain {
        ktorClient()
        ktorSerialization()
    }
    commonTest {
        mockKtorClient()
    }
    jvmTest {
        jvmTest()
        jvmKtorClient()
    }
}