import com.android.build.gradle.LibraryExtension
import org.gradle.api.JavaVersion
import org.gradle.api.NamedDomainObjectContainer
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.plugin.KotlinDependencyHandler
import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet

private const val PERSONAL_EXTENSION = "2.1.0"
private const val KTX_DATETIME = "0.3.0"
private const val KTX_SERIALIZATION = "1.3.0"
private const val KTOR = "1.6.4"
private const val SQL_DELIGHT = "1.5.1"
private const val ANDROID_TEST = "1.1.0"
private const val ROBOLECTRIC = "4.6.1"
private const val COROUTINE = "1.5.2"
const val KOTLIN = "1.5.30"

fun KotlinDependencyHandler.ktxDateTime() = implementation("org.jetbrains.kotlinx:kotlinx-datetime:$KTX_DATETIME")
fun KotlinDependencyHandler.ktxSerialization() = implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:$KTX_SERIALIZATION")
fun KotlinDependencyHandler.v2Client() = implementation(project(":v2-client"))
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
fun KotlinDependencyHandler.androidSqlDelight() = implementation("com.squareup.sqldelight:android-driver:$SQL_DELIGHT")
fun KotlinDependencyHandler.jvmSqlDelight() = implementation("com.squareup.sqldelight:sqlite-driver:$SQL_DELIGHT")
fun KotlinDependencyHandler.coroutine() = implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$COROUTINE")

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
            implementation("androidx.test.ext:junit:$ANDROID_TEST")
            implementation("androidx.test:core:$ANDROID_TEST")
            implementation("androidx.test:runner:$ANDROID_TEST")
            implementation("androidx.test:rules:$ANDROID_TEST")
            implementation("org.robolectric:robolectric:$ROBOLECTRIC")
            block(this)
        }
    }
}

/**
 * Sets up Android.
 */
fun LibraryExtension.setup(manifestPath: String = "src/androidMain/AndroidManifest.xml", block: LibraryExtension.() -> Unit = {})
{
    compileSdk = 30
    sourceSets.getByName("main").manifest.srcFile(manifestPath)
    defaultConfig {
        minSdk = 23
        targetSdk = 30
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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