tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = Metadata.JVM_TARGET
}

allprojects {
    group = "${Metadata.GROUP_ID}.${Metadata.SUBGROUP_ID}"
    version = Metadata.VERSION

    apply(plugin = "maven-publish")
    apply(plugin = "signing")

    repositories {
        google()
        mavenCentral()
        mavenLocal()
        maven("https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/")
        maven("https://s01.oss.sonatype.org/content/repositories/snapshots/")
    }

    val jar by project.tasks.registering(org.gradle.api.tasks.bundling.Jar::class) {
        archiveClassifier.set("javadoc")
    }

    ext.set("jar", jar)
}