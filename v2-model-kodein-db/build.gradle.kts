plugins {
    id(libs.plugins.multiplatform.get().pluginId)
    id(libs.plugins.android.library.get().pluginId)
}

publishing.publish(
    project = project,
    description = "Kodein-DB extensions for v2-model."
)

android.setup(project)

kotlin.setup {
    commonMain {
        api(libs.bundles.common)
        api(libs.woody230.ktx.kodein.db)
        api(projects.v2ModelExtension)
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