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
        v2ScopeProcessor()
        ktxDateTime()
        ktorClient()
        ktorClientSerialization()
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