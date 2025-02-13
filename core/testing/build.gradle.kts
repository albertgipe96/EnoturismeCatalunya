plugins {
    alias(libs.plugins.enoturismecatalunya.jvm.library)
}

dependencies {
    implementation(libs.junit.jupiter.api)
    implementation(libs.kotest)
    implementation(libs.mockk)
    implementation(libs.kotlinx.coroutines.test)
}
