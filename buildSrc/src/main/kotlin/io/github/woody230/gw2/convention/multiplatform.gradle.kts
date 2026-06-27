package io.github.woody230.gw2.convention

import com.bselzer.gradle.internal.android.kotlin.multiplatform.library.plugin.multiplatformAndroidLibraryExtension
import com.bselzer.gradle.internal.maven.publish.plugin.Licensing
import com.bselzer.gradle.internal.multiplatform.publish.plugin.multiplatformPublishExtension
import com.bselzer.gradle.multiplatform.configure.sourceset.multiplatformDependencies
import libs

// TODO can't access libs from precompiled scripts https://github.com/gradle/gradle/issues/15383
plugins {
    alias(libs.plugins.woody230.gradle.internal.multiplatform.android.library)
    alias(libs.plugins.woody230.gradle.internal.multiplatform)
    alias(libs.plugins.woody230.gradle.internal.multiplatform.jvm.target)
    alias(libs.plugins.woody230.gradle.internal.multiplatform.test)
    alias(libs.plugins.woody230.gradle.internal.multiplatform.publish)
}

multiplatformAndroidLibraryExtension {
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