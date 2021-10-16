plugins {
    kotlin("multiplatform")
    id("com.android.library")
}

android.setup()
kotlin.setup {
    commonMain {
        v2Tile()
        v2Model()
        v2Client()
        ktxSerialization()
        ktorClient()
        coroutine()
        personalKtxGeometry()
    }
    commonTest()
    androidTest {
        androidTest()
        androidKtorClient()
    }
}