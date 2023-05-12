package com.awvgp.template.composite

import com.awvgp.template.util.configureHiltSettings
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies

/**
 * Plugin for configuring android feature libraries. Sets up hilt dependencies.
 */
open class AndroidFeaturePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                //Library must be setup in advance otherwise we will be unable to configure implementation
                // and kapt dependencies
                apply("awvgp.template.android.library")
            }
            configureHiltSettings()


            val libs = extensions.getByType(VersionCatalogsExtension::class.java).named("libs")
            dependencies {

                //https://developer.android.com/kotlin/coroutines#dependency
                add("implementation", libs.findLibrary("kotlinx-coroutines-android").get())

                // Lifecycle aware ViewModelScope
                // https://developer.android.com/topic/libraries/architecture/coroutines#dependencies
                add("implementation", libs.findLibrary("androidx-lifecycle-viewmodel").get())

            }
        }

    }
}
