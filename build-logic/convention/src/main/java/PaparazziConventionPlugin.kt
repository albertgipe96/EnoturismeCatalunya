import com.development.buildlogic.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class PaparazziConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.run {
                apply("app.cash.paparazzi")
            }
            dependencies {
                "testImplementation"(libs.findLibrary("paparazzi").get())
            }
        }
    }
}
