package com.awvgp.template.util

import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.jetbrains.kotlin.gradle.plugin.KaptExtension


/**
 * Sets up basic hilt plugins and requirements:
 *
 * [Hilt Setup](https://developer.android.com/training/dependency-injection/hilt-android#setup)
 */
fun Project.configureHiltSettings() {
    with(pluginManager) {
        apply("kotlin-kapt")
        apply("com.google.dagger.hilt.android")
    }

    val libs = extensions.getByType(org.gradle.api.artifacts.VersionCatalogsExtension::class.java)
        .named("libs")

    //dependencies.add("implementation", libs.findLibrary("dagger.hilt.android").get())
    dependencies {
        add("implementation", libs.findLibrary("dagger.hilt.android").get())
        add("kapt", libs.findLibrary("dagger.hilt.compiler").get())
    }

    extensions.getByType(KaptExtension::class.java).correctErrorTypes = true
}