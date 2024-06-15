import com.bselzer.gradle.multiplatform.configure.sourceset.multiplatformDependencies

plugins {
    id(libs.plugins.woody230.gw2.convention.multiplatform.get().pluginId)
    alias(libs.plugins.ktx.serialization)

    // ktx-datetime-serialization needs desugaring
    id(libs.plugins.woody230.gradle.internal.android.desugar.get().pluginId)
}

multiplatformPublishExtension {
    description.set("Guild Wars 2 API models for v2-client.")
}

multiplatformDependencies {
    commonMain {
        api(projects.v2Scope)
        api(libs.woody230.ktx.serialization.json)
        api(libs.woody230.ktx.datetime.serialization)
        api(libs.woody230.ktx.value.identifier)
        api(libs.woody230.ktx.geometry.serialization)
    }
}