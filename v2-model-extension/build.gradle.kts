plugins {
    kotlin("multiplatform")
    id("com.android.library")
}

android.setup()

kotlin.setup {
    commonMain {
        v2Model()
        v2ModelEnumeration()
        extGeometry()
    }
    commonTest()
    jvmTest()
}