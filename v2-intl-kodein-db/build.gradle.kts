plugins {
    kotlin("multiplatform")
    id("com.android.library")
}

publishing.publish(
    project = project,
    description = "Kodein-DB extensions for v2-intl."
)

android.setup()

kotlin.setup {
    commonMain {
        v2Intl()
        extKodeinDb()
    }
    commonTest()
}