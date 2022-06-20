plugins {
    kotlin("multiplatform")
    id("com.android.library")
    kotlin("plugin.serialization") version Versions.KOTLIN
}

publishing.publish(
    project = project,
    description = "Ktor client for v2 endpoints of the Guild Wars 2 API."
)

android.setup()

kotlin.setup {
    commonMain {
        v2Model()
        v2Scope()
        ktxDateTime()
        ktorClient()
        ktorSerialization()
    }
    commonTest {
        v2ModelEnumeration()
        mockKtorClient()
    }
    jvmTest {
        jvmTest()
        jvmKtorClient()
    }
}