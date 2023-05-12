plugins {
    //Gradle core plugin for writing plugins via the kotlin DSL
    `kotlin-dsl`
}

group = "com.awvgp.template.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidComposeApp") {
            id = "awvgp.template.android.application"
            implementationClass = "com.awvgp.template.composite.AndroidComposeAppPlugin"
        }
        register("androidLibrary") {
            id = "awvgp.template.android.library"
            implementationClass = "com.awvgp.template.composite.AndroidLibPlugin"
        }
        register("androidLibraryCompose") {
            id = "awvgp.template.android.library.compose"
            implementationClass = "com.awvgp.template.composite.AndroidLibComposePlugin"
        }
        register("androidFeature") {
            id = "awvgp.template.android.feature"
            implementationClass = "com.awvgp.template.composite.AndroidFeaturePlugin"
        }
    }
}
