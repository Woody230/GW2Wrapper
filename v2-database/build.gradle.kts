plugins {
    kotlin("multiplatform")
    id("com.android.library")
    kotlin("plugin.serialization")
    id("com.squareup.sqldelight")
}

android.setup()

kotlin.setup {
    commonMain {
        v2Model()
    }
    commonTest()
    androidMain {
        androidSqlDelight()
    }
    androidTest()
    jvmMain {
        jvmSqlDelight()
    }
    jvmTest()
}

sqldelight {
    database("Gw2Database") {
        packageName = "com.bselzer.library.gw2.v2.database"
    }
}