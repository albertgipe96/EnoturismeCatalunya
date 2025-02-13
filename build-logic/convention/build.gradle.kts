plugins {
    `kotlin-dsl`
}

group = "com.development.buildlogic"

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.android.tools.common)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.ksp.gradlePlugin)
    compileOnly(libs.room.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "enoturismecatalunya.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidLibrary") {
            id = "enoturismecatalunya.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("androidLibraryCompose") {
            id = "enoturismecatalunya.android.library.compose"
            implementationClass = "AndroidLibraryComposeConventionPlugin"
        }
        register("jvmLibrary") {
            id = "enoturismecatalunya.jvm.library"
            implementationClass = "JvmLibraryConventionPlugin"
        }
        register("jvm-test") {
            id = "enoturismecatalunya.jvm.test"
            implementationClass = "JvmTestConventionPlugin"
        }
        register("android-test") {
            id = "enoturismecatalunya.android.test"
            implementationClass = "AndroidTestConventionPlugin"
        }
        register("paparazzi") {
            id = "enoturismecatalunya.paparazzi"
            implementationClass = "PaparazziConventionPlugin"
        }

    }
}
