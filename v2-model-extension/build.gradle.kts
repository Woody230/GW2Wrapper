plugins {
    kotlin("multiplatform")
    id("com.android.library")
}

android.setup()

kotlin.setup {
    commonMain {
        v2Model()
        extGeometry()
    }
    commonTest()
    jvmTest()
}