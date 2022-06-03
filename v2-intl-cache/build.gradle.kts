plugins {
    kotlin("multiplatform")
    id("com.android.library")
}

publishing.publish(project)

android.setup()

kotlin.setup {
    commonMain {
        v2Intl()
        extKodeinDb()
    }
    commonTest()
}