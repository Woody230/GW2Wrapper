plugins {
    kotlin("multiplatform")
    id("com.android.library")
    kotlin("plugin.serialization") version Versions.KOTLIN
}

publishing.publish(project)

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