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
            implementationClass = "AndroidComposeAppPlugin"
        }
    }
}
