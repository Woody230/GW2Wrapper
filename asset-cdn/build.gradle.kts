plugins {
    kotlin("multiplatform")
    id("com.android.library")
    kotlin("plugin.serialization") version Versions.KOTLIN
}

publishing.publish(
    project = project,
    description = "Build information from ArenaNet's assetcdn."
)

android.setup()

kotlin.setup {
    commonMain {
        ktorClient()
        ktorSerialization()
        v2Model()
    }
    commonTest {
        mockKtorClient()
    }
    jvmTest {
        jvmTest()
        jvmKtorClient()
    }
}