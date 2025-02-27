import com.android.build.gradle.LibraryExtension
import com.development.buildlogic.convention.configureAndroidCompose
import com.development.buildlogic.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

class AndroidLibraryComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.run {
            pluginManager.run {
                apply("enoturismecatalunya.android.library")
                apply("org.jetbrains.kotlin.plugin.compose")
                apply("enoturismecatalunya.paparazzi")
            }
            val extension = extensions.getByType<LibraryExtension>()
            configureAndroidCompose(extension)
            dependencies {
                add("implementation", libs.findLibrary("hilt.navigation.compose").get())
            }
        }
    }
}
