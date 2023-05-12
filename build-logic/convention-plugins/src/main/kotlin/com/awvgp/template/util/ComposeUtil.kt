package com.awvgp.template.util

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

/**
 * Set's up general compose requirements for both application and libraries
 *
 * [Compose Setup Docs](https://developer.android.com/jetpack/compose/setup?gclid=CjwKCAjwx_eiBhBGEiwA15gLN-HDaE-v1gm3pdDv8lHbSFcgv8qg77hVwEf9QDbolM4__wDbW17d0BoC-sUQAvD_BwE&gclsrc=aw.ds#setup-compose)
 */
fun Project.configureComposeSettings(target: CommonExtension<*, *, *, *>) {

    val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

    target.apply {
        buildFeatures {
            compose = true
        }

        //  Kotlin Compiler extension versioning defined in the ComposeOptions block is tied to
        //  Kotlin versioning. Make sure to consult the Compatibility map and choose a version of
        //  the library that matches your project’s Kotlin version.
        composeOptions.apply {
            kotlinCompilerExtensionVersion =
                libs.findVersion("androidxComposeCompiler").get().toString()
        }

    }

    dependencies {
        //setup compose BoM, individual projects still have to include which dependencies they want.
        val bom = libs.findLibrary("androidx-compose-bom").get()
        add("implementation", platform(bom))
        add("androidTestImplementation", platform(bom))

    }

}