import com.bselzer.gradle.multiplatform.configure.sourceset.multiplatformDependencies

plugins {
    id(libs.plugins.woody230.gw2.convention.multiplatform.get().pluginId)
    id(libs.plugins.woody230.gradle.internal.moko.resources.get().pluginId)

    // v2-model-enumeration needs desugaring
    id(libs.plugins.woody230.gradle.internal.android.desugar.get().pluginId)
}

multiplatformResources {
    resourcesPackage.set("com.bselzer.gw2.v2.resource")
    resourcesClassName.set("Gw2Resources")
}

multiplatformPublishExtension {
    description.set("Guild Wars 2 moko-resources strings and images")
}

multiplatformDependencies {
    commonMain {
        api(projects.v2ModelEnumeration)
        api(libs.woody230.ktx.resource)
    }
}