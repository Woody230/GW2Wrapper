plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("dev.icerock.mobile.multiplatform-resources") version Versions.RESOURCE
}

multiplatformResources {
    multiplatformResourcesPackage = "com.bselzer.gw2.v2.resource"
    multiplatformResourcesClassName = "Gw2Resources"
}

publishing.publish(project)

android.setup()

kotlin.setup {
    commonMain {
        v2ModelEnumeration()
        extResource()
    }
    commonTest()
}
