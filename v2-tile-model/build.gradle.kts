import com.bselzer.gradle.multiplatform.configure.sourceset.multiplatformDependencies

plugins {
    id(libs.plugins.woody230.gw2.convention.multiplatform.get().pluginId)
    alias(libs.plugins.ktx.serialization)
}

multiplatformPublishExtension {
    description.set("Tiling service models for Guild Wars 2 map images.")
}

multiplatformDependencies {
    commonMain {
        api(projects.v2Model)
        api(libs.ktx.serialization.core)
    }
}