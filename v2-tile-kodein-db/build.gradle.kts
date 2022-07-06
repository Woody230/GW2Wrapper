plugins {
    kotlin("multiplatform")
    id("com.android.library")
}

publishing.publish(
    project = project,
    description = "Kodein-DB extensions for v2-tile."
)

android.setup()

kotlin.setup {
    commonMain {
        v2Tile()
        extKodeinDb()
    }
    commonTest()
}