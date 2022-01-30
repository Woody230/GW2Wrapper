plugins {
    kotlin("multiplatform")
    id("com.android.library")
}

publishing.publish(project)

android.setup()

kotlin.setup {
    commonMain {
        extKodeinDb()
        v2Client()
        v2ModelExtension()
    }
    commonTest {
        mockKtorClient()
        testKodeinDb()
    }
    jvmTest()
}