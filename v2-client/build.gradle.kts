plugins {
    id(libs.plugins.multiplatform.get().pluginId)
    id(libs.plugins.android.library.get().pluginId)
    alias(libs.plugins.ktx.serialization)
}

publishing.publish(
    project = project,
    description = "Ktor client for v2 endpoints of the Guild Wars 2 API."
)

android.setup(project)

kotlin.setup {
    commonMain {
        api(libs.bundles.common)
        api(projects.v2Model)
        api(projects.v2Scope)
        api(libs.ktx.datetime)
        api(libs.ktor.client)
    }
    commonTest {
        implementation(libs.bundles.common.test)
        implementation(projects.v2ModelEnumeration)
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