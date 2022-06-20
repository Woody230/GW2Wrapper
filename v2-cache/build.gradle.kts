plugins {
    kotlin("multiplatform")
    id("com.android.library")
}

publishing.publish(
    project = project,
    description = "Kodein-DB caching framework for v2-client."
)

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