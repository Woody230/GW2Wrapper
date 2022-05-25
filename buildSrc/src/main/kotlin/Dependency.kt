import com.android.build.gradle.LibraryExtension
import org.gradle.api.JavaVersion
import org.gradle.api.NamedDomainObjectContainer
import org.gradle.api.Project
import org.gradle.api.publish.PublishingExtension
import org.gradle.api.publish.maven.MavenPom
import org.gradle.api.publish.maven.MavenPublication
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.plugin.KotlinDependencyHandler
import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet

private const val BASE_PUBLISHING_NAME = "gw2"
private const val EXTENSION = "4.0.0"
private const val KTX_DATETIME = "0.3.2"
private const val KTX_SERIALIZATION = "1.3.2"
private const val KTOR = "2.0.1"
private const val ANDROID_TEST = "1.1.0"
private const val ROBOLECTRIC = "4.6.1"
private const val COROUTINE = "1.5.2"
private const val KODEIN_DB = "0.9.0-beta"
const val KOTLIN = "1.6.10"

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
fun KotlinDependencyHandler.v2Tile() = api(project(":v2-tile"))
fun KotlinDependencyHandler.v2Intl() = api(project(":v2-intl"))

fun KotlinDependencyHandler.extSerialization() = api("com.bselzer.ktx:serialization:$EXTENSION")
fun KotlinDependencyHandler.extFunction() = api("com.bselzer.ktx:function:$EXTENSION")
fun KotlinDependencyHandler.extBase64() = api("com.bselzer.ktx:base64:$EXTENSION")
fun KotlinDependencyHandler.extDateTime() = api("com.bselzer.ktx:datetime:$EXTENSION")
fun KotlinDependencyHandler.extGeometry() = api("com.bselzer.ktx:geometry:$EXTENSION")
fun KotlinDependencyHandler.extKodeinDb() = api("com.bselzer.ktx:kodein-db:$EXTENSION")
fun KotlinDependencyHandler.extValue() = api("com.bselzer.ktx:value:$EXTENSION")

// Test
fun KotlinDependencyHandler.androidKtorClient() = implementation("io.ktor:ktor-client-android:$KTOR")
fun KotlinDependencyHandler.jvmKtorClient() = implementation("io.ktor:ktor-client-apache:$KTOR")
fun KotlinDependencyHandler.mockKtorClient() = implementation("io.ktor:ktor-client-mock:$KTOR")
fun KotlinDependencyHandler.testKodeinDb() {
    api("org.kodein.db:kodein-db:$KODEIN_DB")
    api("org.kodein.db:kodein-db-inmemory:$KODEIN_DB")
    api("org.kodein.db:kodein-db-serializer-kotlinx:$KODEIN_DB")
}

/**
 * Sets up common dependencies.
 */
fun NamedDomainObjectContainer<KotlinSourceSet>.commonMain(block: KotlinDependencyHandler.() -> Unit = {}) {
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
    compileSdk = 31
    sourceSets.getByName("main").manifest.srcFile(manifestPath)
    defaultConfig {
        minSdk = 21
        targetSdk = 31
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    publishing {
        multipleVariants {
            allVariants()
            withSourcesJar()
            withJavadocJar()
        }
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
fun KotlinMultiplatformExtension.setup(sourceSets: NamedDomainObjectContainer<KotlinSourceSet>.() -> Unit = {}) {
    targets()
    sourceSets(this.sourceSets)
}

/**
 * Sets up the pom.xml that gets created using the maven-publish plugin.
 *
 * @see <a href="https://docs.gradle.org/current/userguide/publishing_customization.html">gradle</a>
 * @see <a href="https://maven.apache.org/pom.html">pom.xml</a>
 */
fun PublishingExtension.publish(project: Project) = publications.withType<MavenPublication>().configureEach {
    pom {
        name.set("${BASE_PUBLISHING_NAME}-${project.name}")
        licenses()
        developers()
    }
}

/**
 * Sets up the pom.xml licenses.
 */
private fun MavenPom.licenses() = licenses {
    license {
        this.name.set("The Apache Software License, Version 2.0")
        url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
        distribution.set("repo")
    }
}

/**
 * Sets up the pom.xml developers.
 */
private fun MavenPom.developers() = developers {
    developer {
        name.set("Brandon Selzer")
    }
}