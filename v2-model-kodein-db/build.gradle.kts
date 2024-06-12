import com.bselzer.gradle.multiplatform.configure.sourceset.multiplatformDependencies

plugins {
    id(libs.plugins.woody230.gw2.convention.multiplatform.get().pluginId)

    // v2-model-extension project needs desugaring
    id(libs.plugins.woody230.gradle.internal.android.desugar.get().pluginId)
}

multiplatformPublishExtension {
    description.set("Kodein-DB extensions for v2-model.")
}

multiplatformDependencies {
    commonMain {
        api(libs.woody230.ktx.kodein.db)
        api(projects.v2ModelExtension)
    }
    commonTest {
        implementation(projects.v2Client)
        implementation(libs.bundles.kodein.db.test)
        implementation(libs.bundles.ktor.client.test)
    }
    androidUnitTest {
        implementation(libs.ktor.client.okhttp)
    }
    jvmTest {
        implementation(libs.ktor.client.okhttp)
    }
}