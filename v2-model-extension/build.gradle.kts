import com.bselzer.gradle.multiplatform.configure.sourceset.multiplatformDependencies

plugins {
    id(libs.plugins.woody230.gw2.convention.multiplatform.get().pluginId)
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