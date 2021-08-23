import com.android.build.gradle.LibraryExtension
import org.gradle.api.JavaVersion
import org.gradle.api.NamedDomainObjectContainer
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.plugin.KotlinDependencyHandler
import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet

private const val PERSONAL_EXTENSION = "1.2.15"
private const val KTX_DATETIME = "0.2.1"
private const val KTX_SERIALIZATION = "1.2.2"
private const val KTOR = "1.6.2"
const val KOTLIN = "1.5.20"

fun KotlinDependencyHandler.ktxDateTime() = implementation("org.jetbrains.kotlinx:kotlinx-datetime:$KTX_DATETIME")
fun KotlinDependencyHandler.ktxSerialization() = implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:$KTX_SERIALIZATION")
fun KotlinDependencyHandler.v2Model() = implementation(project(":v2-model"))
fun KotlinDependencyHandler.v2ModelEnumeration() = implementation(project(":v2-model-enumeration"))
fun KotlinDependencyHandler.v2Scope() = implementation(project(":v2-scope"))
fun KotlinDependencyHandler.v2ScopeProcessor() = implementation(project(":v2-scope-processor"))
fun KotlinDependencyHandler.personalKtxSerialization() = implementation("com.github.Woody230.KotlinExtensions:serialization:$PERSONAL_EXTENSION")
fun KotlinDependencyHandler.personalKtxFunction() = implementation("com.github.Woody230.KotlinExtensions:function:$PERSONAL_EXTENSION")
fun KotlinDependencyHandler.personalKtxBase64() = implementation("com.github.Woody230.KotlinExtensions:base64:$PERSONAL_EXTENSION")
fun KotlinDependencyHandler.personalKtxDateTime() = implementation("com.github.Woody230.KotlinExtensions:datetime:$PERSONAL_EXTENSION")
fun KotlinDependencyHandler.jvmKtorClient() = implementation("io.ktor:ktor-client-apache:$KTOR")
fun KotlinDependencyHandler.mockKtorClient() = implementation("io.ktor:ktor-client-mock:$KTOR")
fun KotlinDependencyHandler.ktorClient() = implementation("io.ktor:ktor-client-core:$KTOR")
fun KotlinDependencyHandler.ktorClientSerialization() = implementation("io.ktor:ktor-client-serialization:$KTOR")

/**
 * Sets up common dependencies.
 */
fun NamedDomainObjectContainer<KotlinSourceSet>.commonMain(block: KotlinDependencyHandler.() -> Unit = {})
{
    getByName("commonMain") {
        dependencies {
            implementation(kotlin("stdlib-common"))
            block(this)
        }
    }
}

/**
 * Sets up common test dependencies.
 */
fun NamedDomainObjectContainer<KotlinSourceSet>.commonTest(block: KotlinDependencyHandler.() -> Unit = {})
{
    getByName("commonTest") {
        dependencies {
            implementation(kotlin("test-common"))
            implementation(kotlin("test-annotations-common"))
            implementation(kotlin("test-junit"))
            block(this)
        }
    }
}

/**
 * Sets up JVM dependencies.
 */
fun NamedDomainObjectContainer<KotlinSourceSet>.jvmMain(block: KotlinDependencyHandler.() -> Unit = {})
{
    getByName("jvmMain") {
        dependencies {
            block(this)
        }
    }
}

/**
 * Sets up JVM test dependencies.
 */
fun NamedDomainObjectContainer<KotlinSourceSet>.jvmTest(block: KotlinDependencyHandler.() -> Unit = {})
{
    getByName("jvmTest") {
        dependencies {
            implementation(kotlin("test-junit"))
            block(this)
        }
    }
}

/**
 * Sets up Android dependencies.
 */
fun NamedDomainObjectContainer<KotlinSourceSet>.androidMain(block: KotlinDependencyHandler.() -> Unit = {})
{
    getByName("androidMain") {
        dependencies {
            block(this)
        }
    }
}

/**
 * Sets up Android test dependencies.
 */
fun NamedDomainObjectContainer<KotlinSourceSet>.androidTest(block: KotlinDependencyHandler.() -> Unit = {})
{
    getByName("androidTest") {
        dependencies {
            implementation(kotlin("test-junit"))
            block(this)
        }
    }
}

/**
 * Sets up Android.
 */
fun LibraryExtension.setup(manifestPath: String = "src/androidMain/AndroidManifest.xml", block: LibraryExtension.() -> Unit = {})
{
    compileSdkVersion(30)
    sourceSets.getByName("main").manifest.srcFile(manifestPath)
    defaultConfig {
        minSdkVersion(23)
        targetSdkVersion(30)
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    block(this)
}

/**
 * Sets up Kotlin multiplatform targets.
 */
private fun KotlinMultiplatformExtension.targets()
{
    jvm()
    android {
        publishLibraryVariants("release", "debug")
    }
}

/**
 * Sets up Kotlin multiplatform.
 */
fun KotlinMultiplatformExtension.setup(sourceSets: NamedDomainObjectContainer<KotlinSourceSet>.() -> Unit = {})
{
    targets()
    sourceSets(this.sourceSets)
}