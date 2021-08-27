plugins {
    `kotlin-dsl`
}

repositories {
    google()
    mavenCentral()
    maven { setUrl("https://jitpack.io") }
}

dependencies {
    implementation(kotlin("gradle-plugin:1.5.30"))
    implementation("com.android.tools.build:gradle:4.2.0")
}