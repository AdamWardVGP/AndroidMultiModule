package com.awvgp.template.feature.nameinput.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.awvgp.template.feature.nameinput.NameInputRoute

fun NavController.navigateToNameInput() {
    this.navigate("name_input_route")
}

fun NavGraphBuilder.nameInputScreen(
    onNavigateToHelloName: (String) -> Unit
) {
    composable(
        route = "name_input_route"
    ) {
        NameInputRoute(onNavigateToHelloName)
    }
}
