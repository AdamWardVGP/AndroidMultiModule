package com.awvgp.template.composite

import com.android.build.api.dsl.LibraryExtension
import com.awvgp.template.util.configureKotlinAndroidSettings
import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * Base plugin for configuring android libraries. Sets up required plugins and kotlin/android settings.
 */
open class AndroidLibPlugin : Plugin<Project> {
    override fun apply(target: Project) {

        with(target) {
            with(pluginManager) {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
            }

            target.extensions.getByType(LibraryExtension::class.java).apply {
                configureKotlinAndroidSettings(this)
            }
        }
    }
}
