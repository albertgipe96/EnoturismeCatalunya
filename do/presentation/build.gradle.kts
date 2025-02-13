plugins {
    alias(libs.plugins.enoturismecatalunya.android.library.compose)
}

android {
    namespace = "com.development.dos.presentation"
}

dependencies {
    implementation(projects.core.designSystem)
    implementation(projects.core.domain)
    implementation(projects.`do`.domain)

    // Navigation
    implementation(libs.androidx.navigation.compose)

    // Coil
    implementation(libs.coil.compose)
    implementation(libs.coil.network)

    implementation(libs.androidx.material3)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
