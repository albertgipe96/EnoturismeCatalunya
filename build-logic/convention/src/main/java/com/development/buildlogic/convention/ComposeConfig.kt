package com.development.buildlogic.convention

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configureAndroidCompose(
    commonExtension: CommonExtension<*, *, *, *, *, *>
) {
    commonExtension.run {
        buildFeatures {
            compose = true
        }
        composeOptions {
            kotlinCompilerExtensionVersion = libs.findVersion("composeCompiler").get().toString()
        }
        dependencies {
            val bom = libs.findLibrary("androidx.compose.bom").get()
            "implementation"(platform(bom))
            "implementation"(project.libs.findBundle("compose").get())

            "debugImplementation"(project.libs.findBundle("compose.debug").get())

            "androidTestImplementation"(platform(bom))
            "androidTestImplementation"(project.libs.findLibrary("androidx.ui.test.junit4").get())
        }
    }
}
