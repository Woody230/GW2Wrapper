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
        ktxDateTime()
        ktorClient()
        ktorClientSerialization()
    }
    commonTest {
        v2ModelEnumeration()
        mockKtorClient()
    }
    androidMain {
        reflection()
    }
    jvmMain {
        reflection()
    }
    jvmTest {
        jvmTest()
        jvmKtorClient()
    }
}