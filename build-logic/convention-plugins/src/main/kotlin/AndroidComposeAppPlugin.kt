import com.android.build.api.dsl.ApplicationExtension
import com.awvgp.template.util.configureComposeOptions
import com.awvgp.template.util.configureKotlinAndroidSettings
import org.gradle.api.Plugin
import org.gradle.api.Project

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

            this.extensions.getByType(ApplicationExtension::class.java).apply {
                configureKotlinAndroidSettings(this)
                configureComposeOptions(this)
            }
        }
    }
}