plugins {
    id("awvgp.template.android.library")
    id("awvgp.template.android.library.compose")
}

android {
    namespace = "com.awvgp.template.core.ui"
}

dependencies {


    //Compose libs:
    //[Compose Setup Docs](https://developer.android.com/jetpack/compose/setup?gclid=CjwKCAjwx_eiBhBGEiwA15gLN-HDaE-v1gm3pdDv8lHbSFcgv8qg77hVwEf9QDbolM4__wDbW17d0BoC-sUQAvD_BwE&gclsrc=aw.ds#setup-compose)
    //[Lifecycle Components](https://developer.android.com/jetpack/androidx/releases/lifecycle#kotlin)
    api(libs.androidx.compose.material3)

    api(libs.androidx.compose.ui.tooling.preview)
    debugApi(libs.androidx.compose.ui.tooling)

    // Integration with activities
    api(libs.androidx.activity.compose)
    //Integration with Composables
    api(libs.androidx.lifecycle.runtime.compose)
    //Integration with ViewModels
    api(libs.androidx.lifecycle.viewmodel.compose)

    //Navigation:
    //[Navigation Dependencies](https://developer.android.com/jetpack/androidx/releases/navigation#declaring_dependencies)
    api(libs.androidx.navigation.ui.ktx)
    api(libs.androidx.navigation.runtime.ktx)
    api(libs.androidx.navigation.compose)
    api(libs.androidx.hilt.navigation)

}