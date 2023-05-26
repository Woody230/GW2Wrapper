import com.bselzer.gradle.multiplatform.configure.sourceset.multiplatformDependencies

plugins {
    id(libs.plugins.woody230.gw2.convention.multiplatform.get().pluginId)
    alias(libs.plugins.ktx.serialization)
}

multiplatformPublishExtension {
    description.set("Internalization support by mapping translations from Guild Wars 2 API models.")
}

multiplatformDependencies {
    commonMain {
        api(libs.ktx.serialization.core)
        api(projects.v2Model)
        implementation(libs.woody230.ktx.function)
    }
}