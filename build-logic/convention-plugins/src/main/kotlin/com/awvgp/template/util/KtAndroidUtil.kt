package com.awvgp.template.util

import com.android.build.api.dsl.ApplicationDefaultConfig
import com.android.build.api.dsl.CommonExtension
import com.android.build.api.dsl.LibraryDefaultConfig
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.api.plugins.ExtensionAware
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions

/**
 * Configures Kotlin/Android settings for both library and android projects.  Both lib and app plugins
 * extend from CommonExtension allowing a shared config between them.
 *
 * Projects themselves are still expected to override specific entities including:
 * - namespace
 * - versionCode
 * - versionName
 * - applicationId
 */
fun Project.configureKotlinAndroidSettings(extensionBase: CommonExtension<*, *, *, *>) {

    extensionBase.apply {

        compileSdk = 33

        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_1_8
            targetCompatibility = JavaVersion.VERSION_1_8
        }
        defaultConfig {
            minSdk = 21

            (this as? LibraryDefaultConfig)?.targetSdk = 33
            (this as? ApplicationDefaultConfig)?.targetSdk = 33

            testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
            vectorDrawables {
                useSupportLibrary = true
            }
        }

        (this as ExtensionAware).extensions.configure<KotlinJvmOptions>("kotlinOptions") {
            jvmTarget = JavaVersion.VERSION_1_8.toString()
        }
    }
}