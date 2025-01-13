import com.android.build.api.dsl.LibraryExtension
import com.development.buildlogic.convention.ExtensionType
import com.development.buildlogic.convention.configureBuildTypes
import com.development.buildlogic.convention.configureKotlinAndroid
import com.development.buildlogic.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.kotlin

class AndroidLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.run {
            pluginManager.run {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
                apply("com.google.devtools.ksp")
                apply("com.google.dagger.hilt.android")
                apply("org.jetbrains.kotlin.plugin.serialization")
            }
            extensions.configure<LibraryExtension> {
                configureKotlinAndroid(this)
                configureBuildTypes(this, ExtensionType.LIBRARY)
                defaultConfig {
                    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                    consumerProguardFiles("consumer-rules.pro")
                }
                dependencies {
                    "testImplementation"(kotlin("test"))
                    add("implementation", libs.findLibrary("hilt").get())
                    add("ksp", libs.findLibrary("hilt.compiler").get())
                    add("implementation", libs.findLibrary("kotlinx.serialization.json").get())
                }
            }
        }
    }
}