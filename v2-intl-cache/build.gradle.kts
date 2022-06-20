plugins {
    kotlin("multiplatform")
    id("com.android.library")
}

publishing.publish(
    project = project,
    description = "Kodein-DB caching framework extensions for storing v2-intl translations."
)

android.setup()

kotlin.setup {
    commonMain {
        v2Intl()
        extKodeinDb()
    }
    commonTest()
}