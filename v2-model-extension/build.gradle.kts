plugins {
    kotlin("multiplatform")
    id("com.android.library")
}

publishing.publish(
    project = project,
    description = "Extensions for Guild Wars 2 API models."
)

android.setup()

kotlin.setup {
    commonMain {
        v2Model()
        v2ModelEnumeration()
    }
    commonTest()
    jvmTest()
}