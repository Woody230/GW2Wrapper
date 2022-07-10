import com.codingfeline.buildkonfig.compiler.FieldSpec.Type.STRING

plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization") version Versions.KOTLIN
    id("com.codingfeline.buildkonfig")
}

publishing.publish(
    project = project,
    description = "Client generator for the Guild Wars 2 API."
)

buildkonfig {
    packageName = "com.bselzer.gw2.v2.client.generator"

    defaultConfigs {
        // TODO plugin
        buildConfigField(STRING, "VERSION", Metadata.VERSION)
        buildConfigField(STRING, "MODULE", "${Metadata.ROOT}.${project.name}")
        buildConfigField(STRING, "OUTPUT_DIRECTORY", buildDir.path + "\\" + project.name + "\\" + "commonMain")
        buildConfigField(STRING, "OUTPUT_PACKAGE_NAME", "com.bselzer.gw2.v2.client.instance")
    }
}

kotlin {
    jvm()
    sourceSets {
        commonMain {
            v2Client()
            poet()
        }
        commonTest {
            mockKtorClient()
        }
        jvmTest {
            jvmTest()
            jvmKtorClient()
        }
    }
}