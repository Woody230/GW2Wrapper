plugins {
    id(libs.plugins.multiplatform.get().pluginId)
    id(libs.plugins.android.library.get().pluginId)
    alias(libs.plugins.ktx.serialization)
}

publishing.publish(
    project = project,
    description = "Guild Wars 2 API models for v2-client."
)

android.setup(project)

kotlin.setup {
    commonMain {
        api(libs.bundles.common)
        api(projects.v2Scope)
        api(libs.woody230.ktx.serialization)
        api(libs.woody230.ktx.datetime.serialization)
        api(libs.woody230.ktx.value.identifier)
        api(libs.woody230.ktx.geometry.serialization)
    }
}