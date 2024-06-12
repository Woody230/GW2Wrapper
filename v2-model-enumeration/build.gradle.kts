import com.bselzer.gradle.multiplatform.configure.sourceset.multiplatformDependencies

plugins {
    id(libs.plugins.woody230.gw2.convention.multiplatform.get().pluginId)
    alias(libs.plugins.ktx.serialization)

    // v2-model project needs desugaring
    id(libs.plugins.woody230.gradle.internal.android.desugar.get().pluginId)
}

multiplatformPublishExtension {
    description.set("Enumerations for Guild Wars 2 API models.")
}

multiplatformDependencies {
    commonMain {
        api(projects.v2Model)
        api(libs.woody230.ktx.serialization.json)
    }
}