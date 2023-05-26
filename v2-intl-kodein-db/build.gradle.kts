import com.bselzer.gradle.multiplatform.configure.sourceset.multiplatformDependencies

plugins {
    id(libs.plugins.woody230.gw2.convention.multiplatform.get().pluginId)
}

multiplatformPublishExtension {
    description.set("Kodein-DB extensions for v2-intl.")
}

multiplatformDependencies {
    commonMain {
        api(projects.v2Client)
        api(projects.v2Intl)
        api(libs.woody230.ktx.kodein.db)
    }
}