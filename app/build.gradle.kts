plugins {
    alias(libs.plugins.enoturismecatalunya.android.application)
}

android {
    namespace = "com.development.enoturismecatalunya"

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

dependencies {
    implementation(projects.core.designSystem)
    implementation(projects.`do`.presentation)
    implementation(projects.`do`.domain)
    implementation(projects.`do`.data)

    // Navigation
    implementation(libs.androidx.navigation.compose)

    implementation(libs.androidx.material3)
}
