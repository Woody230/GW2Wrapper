import com.bselzer.gradle.multiplatform.configure.sourceset.multiplatformDependencies

plugins {
    id(libs.plugins.woody230.gw2.convention.multiplatform.get().pluginId)
    alias(libs.plugins.ktx.serialization)

    // v2-model project needs desugaring
    id(libs.plugins.woody230.gradle.internal.android.desugar.get().pluginId)
}

multiplatformPublishExtension {
    description.set("Ktor client for v2 endpoints of the Guild Wars 2 API.")
}

multiplatformDependencies {
    commonMain {
        api(projects.v2Model)
        api(projects.v2Scope)
        api(libs.ktx.serialization.json)
        api(libs.ktx.datetime)
        api(libs.ktor.client)
        api(libs.ktor.client.contentNegotiation)
        api(libs.ktor.serialization.ktx)
    }
    commonTest {
        implementation(projects.v2ModelEnumeration)
        implementation(libs.bundles.ktor.client.test)
    }
    androidUnitTest {
        implementation(libs.ktor.client.okhttp)
    }
    jvmTest {
        implementation(libs.ktor.client.okhttp)
    }
}