import com.bselzer.gradle.multiplatform.configure.sourceset.multiplatformDependencies

plugins {
    id(libs.plugins.woody230.gw2.convention.multiplatform.get().pluginId)
    alias(libs.plugins.ktx.serialization)
}

multiplatformPublishExtension {
    description.set("Build information from ArenaNet's assetcdn.")
}

multiplatformDependencies {
    commonMain {
        api(libs.ktor.client)
        api(projects.v2Model)
    }
    commonTest {
        implementation(libs.bundles.ktor.client.test)
    }
    androidUnitTest {
        implementation(libs.ktor.client.okhttp)
    }
    jvmTest {
        implementation(libs.ktor.client.okhttp)
    }
}