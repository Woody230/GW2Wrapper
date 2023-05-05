plugins {
    id(libs.plugins.multiplatform.get().pluginId)
    id(libs.plugins.android.library.get().pluginId)
    alias(libs.plugins.ktx.serialization)
}

publishing.publish(
    project = project,
    description = "Base64 Guild Wars 2 chat link encoding and decoding."
)

android.setup(project)

kotlin.setup {
    commonMain {
        api(libs.bundles.common)
        api(projects.v2Model)
        api(projects.v2ModelEnumeration)
        api(libs.ktx.serialization.core)
        api(libs.woody230.ktx.base64)
        api(libs.woody230.ktx.function)
    }
    commonTest {
        implementation(libs.bundles.common.test)
    }
    androidUnitTest {
        implementation(libs.bundles.android.unit.test)
    }
    jvmTest {
        implementation(libs.bundles.jvm.test)
    }
}