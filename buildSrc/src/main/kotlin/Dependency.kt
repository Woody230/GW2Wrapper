
import Versions.COROUTINE
import Versions.EXTENSION
import Versions.KODEIN_DB
import Versions.KTOR
import Versions.KTX_DATETIME
import Versions.KTX_SERIALIZATION
import org.jetbrains.kotlin.gradle.plugin.KotlinDependencyHandler

object Versions {
    const val KTX_DATETIME = "0.3.2"
    const val KTX_SERIALIZATION = "1.3.2"
    const val KTOR = "2.0.1"
    const val BUILD_CONFIG = "0.11.0"
    const val ANDROID_TEST = "1.1.0"
    const val ROBOLECTRIC = "4.6.1"
    const val COROUTINE = "1.5.2"
    const val KODEIN_DB = "0.9.0-beta"
    const val KOTLIN = "1.6.10"
    const val RESOURCE = "0.19.0"
    const val EXTENSION = "5.0.0"
}

object Metadata {
    const val GROUP_ID = "io.github.woody230"
    const val SUBGROUP_ID = "gw2"
    const val VERSION = "4.0.0"
    const val JVM_TARGET = "1.8"
    const val ROOT = "GW2Wrapper"
}

object LocalProperty {
    const val SONATYPE_USERNAME = "sonatype.username"
    const val SONATYPE_PASSWORD = "sonatype.password"
    const val SIGNING_KEY_ID = "signing.keyId"
    const val SIGNING_KEY = "signing.key"
    const val SIGNING_PASSWORD = "signing.password"
}

fun KotlinDependencyHandler.ktxDateTime() = api("org.jetbrains.kotlinx:kotlinx-datetime:$KTX_DATETIME")
fun KotlinDependencyHandler.ktxSerialization() = api("org.jetbrains.kotlinx:kotlinx-serialization-json:$KTX_SERIALIZATION")
fun KotlinDependencyHandler.ktorClient() = api("io.ktor:ktor-client-core:$KTOR")
fun KotlinDependencyHandler.ktorSerialization() {
    api("io.ktor:ktor-client-content-negotiation:$KTOR")
    api("io.ktor:ktor-serialization-kotlinx-json:$KTOR")
}

fun KotlinDependencyHandler.coroutine() = api("org.jetbrains.kotlinx:kotlinx-coroutines-core:$COROUTINE")

fun KotlinDependencyHandler.v2Client() = api(project(":v2-client"))
fun KotlinDependencyHandler.v2Model() = api(project(":v2-model"))
fun KotlinDependencyHandler.v2ModelEnumeration() = api(project(":v2-model-enumeration"))
fun KotlinDependencyHandler.v2ModelExtension() = api(project(":v2-model-extension"))
fun KotlinDependencyHandler.v2Scope() = api(project(":v2-scope"))
fun KotlinDependencyHandler.v2TileModel() = api(project(":v2-tile-model"))
fun KotlinDependencyHandler.v2Intl() = api(project(":v2-intl"))

fun KotlinDependencyHandler.extSerialization() = api("io.github.woody230.ktx:serialization:$EXTENSION")
fun KotlinDependencyHandler.extFunction() = api("io.github.woody230.ktx:function:$EXTENSION")
fun KotlinDependencyHandler.extBase64() = api("io.github.woody230.ktx:base64:$EXTENSION")
fun KotlinDependencyHandler.extDateTime() {
    api("io.github.woody230.ktx:datetime:$EXTENSION")
    api("io.github.woody230.ktx:datetime-serialization:$EXTENSION")
}

fun KotlinDependencyHandler.extGeometry() {
    api("io.github.woody230.ktx:geometry:$EXTENSION")
    api("io.github.woody230.ktx:geometry-serialization:$EXTENSION")
}

fun KotlinDependencyHandler.extKodeinDb() = api("io.github.woody230.ktx:kodein-db:$EXTENSION")
fun KotlinDependencyHandler.extValue() = api("io.github.woody230.ktx:value:$EXTENSION")
fun KotlinDependencyHandler.extResource() = api("io.github.woody230.ktx:resource:$EXTENSION")
fun KotlinDependencyHandler.extLogging() = implementation("io.github.woody230.ktx:logging:$EXTENSION")

// Test
fun KotlinDependencyHandler.androidKtorClient() = implementation("io.ktor:ktor-client-android:$KTOR")
fun KotlinDependencyHandler.jvmKtorClient() = implementation("io.ktor:ktor-client-apache:$KTOR")
fun KotlinDependencyHandler.mockKtorClient() = implementation("io.ktor:ktor-client-mock:$KTOR")
fun KotlinDependencyHandler.testKodeinDb() {
    api("org.kodein.db:kodein-db:$KODEIN_DB")
    api("org.kodein.db:kodein-db-inmemory:$KODEIN_DB")
    api("org.kodein.db:kodein-db-serializer-kotlinx:$KODEIN_DB")
}