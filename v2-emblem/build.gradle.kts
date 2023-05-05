plugins {
    id(libs.plugins.multiplatform.get().pluginId)
    id(libs.plugins.android.library.get().pluginId)
    alias(libs.plugins.ktx.serialization)
}

publishing.publish(
    project = project,
    description = "Guild emblem image fetching from https://emblem.werdes.net/"
)

android.setup(project)

kotlin.setup {
    commonMain {
        api(libs.bundles.common)
        api(libs.ktor.client)
        api(libs.ktx.serialization.core)
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