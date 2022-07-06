plugins {
    kotlin("multiplatform")
    id("com.android.library")
}

publishing.publish(
    project = project,
    description = "Kodein-DB extensions for v2-model."
)

android.setup()

kotlin.setup {
    commonMain {
        extKodeinDb()
        v2ModelExtension()
    }
    commonTest {
        mockKtorClient()
        testKodeinDb()
    }
    jvmTest()
}