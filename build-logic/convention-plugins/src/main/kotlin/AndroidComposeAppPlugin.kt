import com.android.build.api.dsl.ApplicationExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.api.plugins.ExtensionAware
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions

/**
 * Provides stock config for application layer classes setting only bare-bones options leaving
 * fields which should be project specific to be left within the project itself
 */
class AndroidComposeAppPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {

            //Retrieve plugin manager and configure it's plugins just like we would in build.gradle
            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
            }

            //This is the android scope from the Android Gradle Plugin found in build.gradle
            extensions.configure<ApplicationExtension> {

                //project namespace should be set on a per-project basis
                //namespace = "com.override.in.project"

                compileSdk = 33

                compileOptions {
                    sourceCompatibility = JavaVersion.VERSION_1_8
                    targetCompatibility = JavaVersion.VERSION_1_8
                }

                defaultConfig {
                    minSdk = 21
                    targetSdk = 32

                    //Fields omitted should be in the project itself i.e.:
                    //versionCode, versionName, applicationId

                    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                    vectorDrawables {
                        useSupportLibrary = true
                    }
                }

                (this as ExtensionAware).extensions.configure<KotlinJvmOptions>("kotlinOptions") {
                    jvmTarget = JavaVersion.VERSION_1_8.toString()
                }

                ConfigureComposeOptions(target, this)
            }
        }
    }
}

fun ConfigureComposeOptions(project: Project, target: ApplicationExtension) {

    val libs = project.extensions.getByType<VersionCatalogsExtension>().named("libs")

    target.apply {
        buildFeatures {
            compose = true
        }

        composeOptions.apply {
            kotlinCompilerExtensionVersion =
                libs.findVersion("androidxComposeCompiler").get().toString()
        }

    }

    project.dependencies {
        //setup compose BoM, individual projects still have to include which dependencies they want
        val bom = libs.findLibrary("androidx-compose-bom").get()
        add("implementation", platform(bom))
        add("androidTestImplementation", platform(bom))
    }

}