import com.bselzer.gradle.multiplatform.configure.sourceset.multiplatformDependencies

plugins {
    id(libs.plugins.woody230.gw2.convention.multiplatform.get().pluginId)
    alias(libs.plugins.ktx.serialization)
}

multiplatformPublishExtension {
    description.set("Base64 Guild Wars 2 chat link encoding and decoding.")
}

multiplatformDependencies {
    commonMain {
        api(projects.v2Model)
        api(projects.v2ModelEnumeration)
        api(libs.ktx.serialization.core)
        api(libs.woody230.ktx.base64)
        api(libs.woody230.ktx.function)
    }
}