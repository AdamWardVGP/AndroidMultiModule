package com.awvgp.template.composite

import com.android.build.api.dsl.LibraryExtension
import com.awvgp.template.util.configureComposeSettings
import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * Compose based plugin for configuring android libraries. Uses base lib plugin settings and layers
 * additional compose requirements.
 */
class AndroidLibComposePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        val libExt = target.extensions.getByType(LibraryExtension::class.java)
        target.configureComposeSettings(libExt)
    }
}