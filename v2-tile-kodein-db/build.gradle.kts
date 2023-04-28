plugins {
    kotlin("multiplatform")
    id("com.android.library")
}

publishing.publish(
    project = project,
    description = "Kodein-DB extensions for v2-tile-model."
)

android.setup(project)

kotlin.setup {
    commonMain {
        v2TileModel()
        extKodeinDb()
    }
    commonTest()
}