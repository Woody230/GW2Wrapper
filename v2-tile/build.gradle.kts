plugins {
    kotlin("multiplatform")
    id("com.android.library")
}

android.setup()

kotlin.setup {
    commonMain {
        v2Model()
        v2Client()
        ktxSerialization()
        ktorClient()
        coroutine()
    }
    commonTest {
        mockKtorClient()
    }
    jvmTest {
        jvmTest()
        jvmKtorClient()
    }
}