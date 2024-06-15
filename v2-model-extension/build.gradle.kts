import com.bselzer.gradle.multiplatform.configure.sourceset.multiplatformDependencies

plugins {
    id(libs.plugins.woody230.gw2.convention.multiplatform.get().pluginId)

    // v2-model project needs desugaring
    id(libs.plugins.woody230.gradle.internal.android.desugar.get().pluginId)
}

multiplatformPublishExtension {
    description.set("Extensions for Guild Wars 2 API models.")
}

multiplatformDependencies {
    commonMain {
        api(projects.v2Model)
        api(projects.v2ModelEnumeration)
    }
}