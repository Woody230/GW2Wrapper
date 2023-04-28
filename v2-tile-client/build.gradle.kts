plugins {
    kotlin("multiplatform")
    id("com.android.library")
    kotlin("plugin.serialization") version Versions.KOTLIN
}

publishing.publish(
    project = project,
    description = "Tiling service for Guild Wars 2 map images."
)

android.setup(project)

kotlin.setup {
    commonMain {
        v2TileModel()
        ktorClient()
        coroutine()
    }
    commonTest {
        mockKtorClient()
        v2Client()
    }
    jvmTest {
        jvmTest()
        jvmKtorClient()
    }
}