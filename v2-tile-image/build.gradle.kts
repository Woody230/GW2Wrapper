plugins {
    kotlin("multiplatform")
    id("com.android.library")
}

publishing.publish(project)

android.setup()

kotlin.setup {
    commonMain {
        v2Tile()
        v2Model()
        v2Client()
        ktxSerialization()
        ktorClient()
        coroutine()
        extGeometry()
    }
    commonTest()
    androidTest {
        androidTest()
        androidKtorClient()
    }
}