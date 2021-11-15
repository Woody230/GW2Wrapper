plugins {
    kotlin("multiplatform")
    id("com.android.library")
}

android.setup()

kotlin.setup {
    commonMain {
        extKodeinDb()
        v2Client()
    }
    commonTest()
}