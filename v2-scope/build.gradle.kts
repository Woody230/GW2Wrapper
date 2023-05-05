plugins {
    id(libs.plugins.multiplatform.get().pluginId)
    id(libs.plugins.android.library.get().pluginId)
    alias(libs.plugins.ktx.serialization)
}

publishing.publish(
    project = project,
    description = "Annotations for permissions required to access Guild Wars 2 API endpoints."
)

android.setup(project)

kotlin.setup {
    commonMain {
        api(libs.bundles.common)
        api(libs.ktx.serialization.core)
    }
}