plugins {
    id(libs.plugins.multiplatform.get().pluginId)
    id(libs.plugins.android.library.get().pluginId)
    alias(libs.plugins.ktx.serialization)
}

publishing.publish(
    project = project,
    description = "Tiling service for Guild Wars 2 map images."
)

android.setup(project)

kotlin.setup {
    commonMain {
        api(libs.bundles.common)
        api(projects.v2TileModel)
        api(libs.ktor.client)
        implementation(libs.ktx.coroutines)
    }
    commonTest {
        implementation(libs.bundles.common.test)
        implementation(libs.bundles.ktor.client.test)
    }
    androidUnitTest {
        implementation(libs.bundles.android.unit.test)
        implementation(libs.ktor.client.okhttp)
    }
    jvmTest {
        implementation(libs.bundles.jvm.test)
        implementation(libs.ktor.client.okhttp)
    }
}