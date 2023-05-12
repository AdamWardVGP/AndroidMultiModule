package com.awvgp.template.util

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

/**
 * Set's up general compose requirements for both application and libraries
 */
fun Project.configureComposeOptions(target: CommonExtension<*, *, *, *>) {

    val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

    target.apply {
        buildFeatures {
            compose = true
        }

        composeOptions.apply {
            kotlinCompilerExtensionVersion =
                libs.findVersion("androidxComposeCompiler").get().toString()
        }

    }

    dependencies {
        //setup compose BoM, individual projects still have to include which dependencies they want
        val bom = libs.findLibrary("androidx-compose-bom").get()
        add("implementation", platform(bom))
        add("androidTestImplementation", platform(bom))
    }

}