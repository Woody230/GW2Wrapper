import com.bselzer.gradle.multiplatform.configure.sourceset.multiplatformDependencies

plugins {
    id(libs.plugins.woody230.gw2.convention.multiplatform.get().pluginId)
    alias(libs.plugins.ktx.serialization)

    // v2-client project needs desugaring
    id(libs.plugins.woody230.gradle.internal.android.desugar.get().pluginId)
}

multiplatformPublishExtension {
    description.set("Tiling service for Guild Wars 2 map images.")
}

multiplatformDependencies {
    commonMain {
        api(projects.v2TileModel)
        api(libs.ktor.client)
        implementation(libs.ktx.coroutines)
    }
    commonTest {
        implementation(projects.v2Client)
        implementation(libs.bundles.ktor.client.test)
    }
    androidUnitTest {
        implementation(libs.ktor.client.okhttp)
    }
    jvmTest {
        implementation(libs.ktor.client.okhttp)
    }
}