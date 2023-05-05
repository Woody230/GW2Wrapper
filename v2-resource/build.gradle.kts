plugins {
    id(libs.plugins.multiplatform.get().pluginId)
    id(libs.plugins.android.library.get().pluginId)
    alias(libs.plugins.moko.resources)
}

multiplatformResources {
    multiplatformResourcesPackage = "com.bselzer.gw2.v2.resource"
    multiplatformResourcesClassName = "Gw2Resources"
}

publishing.publish(
    project = project,
    description = "Guild Wars 2 moko-resources strings and images"
)

android.setup(project)

kotlin.setup {
    commonMain {
        api(libs.bundles.common)
        api(projects.v2ModelEnumeration)
        api(libs.woody230.ktx.resource)
    }
}
