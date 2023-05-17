package com.awvgp.template.feature.helloname.navigation

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.awvgp.template.feature.helloname.HelloNameRoute

internal const val displayNameArg = "displayName"

internal class HelloNameArgs(val name: String) {
    constructor(savedStateHandle: SavedStateHandle) :
            this(savedStateHandle.get<String>(displayNameArg) ?: "")
}

fun NavController.navigateToHelloName(name: String) {
    this.navigate("hello_name_route/$name")
}

fun NavGraphBuilder.helloNameScreen(
    onBackClick: () -> Unit
) {
    composable(
        route = "hello_name_route/{$displayNameArg}",
        arguments = listOf(
            navArgument(displayNameArg) { type = NavType.StringType }
        )
    ) {
        HelloNameRoute(onBackClick = onBackClick)
    }
}
