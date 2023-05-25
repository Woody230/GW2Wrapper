import com.bselzer.gradle.multiplatform.configure.sourceset.multiplatformDependencies

plugins {
    id(libs.plugins.woody230.gw2.convention.multiplatform.get().pluginId)
    alias(libs.plugins.ktx.serialization)
}

multiplatformPublishExtension {
    description.set("Annotations for permissions required to access Guild Wars 2 API endpoints.")
}

multiplatformDependencies {
    commonMain {
        api(libs.ktx.serialization.core)
    }
}