plugins {
    id(libs.plugins.multiplatform.get().pluginId)
    id(libs.plugins.android.library.get().pluginId)
    alias(libs.plugins.ktx.serialization)
}

publishing.publish(
    project = project,
    description = "Tiling service models for Guild Wars 2 map images."
)

android.setup(project)

kotlin.setup {
    commonMain {
        api(libs.bundles.common)
        api(projects.v2Model)
        api(libs.ktx.serialization.core)
    }
}