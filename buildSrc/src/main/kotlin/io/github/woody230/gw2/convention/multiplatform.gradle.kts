package io.github.woody230.gw2.convention

import com.bselzer.gradle.internal.maven.publish.plugin.Licensing
import com.bselzer.gradle.multiplatform.configure.sourceset.multiplatformDependencies
import org.gradle.kotlin.dsl.apply

// TODO can't access libs from precompiled scripts https://github.com/gradle/gradle/issues/15383
plugins {
    id("io.github.woody230.gradle.internal.android-library")
    id("io.github.woody230.gradle.internal.multiplatform")
    id("io.github.woody230.gradle.internal.multiplatform-android-target")
    id("io.github.woody230.gradle.internal.multiplatform-jvm-target")
    id("io.github.woody230.gradle.internal.multiplatform-test")
    id("io.github.woody230.gradle.internal.multiplatform-publish")
}

androidLibraryExtension {
    namespace.category.set("gw2")
}

multiplatformPublishExtension {
    coordinates.category.set("gw2")
    version.set(libs.versions.woody230.gw2)
    repository.set("https://github.com/Woody230/GW2Wrapper")
    licensing.set(Licensing.APACHE_2_0)
}

multiplatformDependencies {
    commonMain {
        api(libs.kotlin.stdlib)
    }
}