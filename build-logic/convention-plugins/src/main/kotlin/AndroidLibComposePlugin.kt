import com.android.build.api.dsl.LibraryExtension
import com.awvgp.template.util.configureComposeOptions
import org.gradle.api.Project
import org.gradle.api.plugins.ExtensionAware

/**
 * Compose based plugin for configuring android libraries. Uses base lib plugin settings and layers
 * additional compose requirements.
 */
class AndroidLibComposePlugin : AndroidLibPlugin() {
    override fun apply(target: Project) {
        super.apply(target)
        val libExt = (target as ExtensionAware).extensions.getByType(LibraryExtension::class.java)
        target.configureComposeOptions(libExt)
    }
}
