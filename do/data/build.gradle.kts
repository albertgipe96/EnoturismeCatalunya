plugins {
    alias(libs.plugins.enoturismecatalunya.android.library)
}

android {
    namespace = "com.development.dos.data"
}

dependencies {
    implementation(projects.core.domain)
    implementation(projects.core.data)
    implementation(projects.`do`.domain)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
