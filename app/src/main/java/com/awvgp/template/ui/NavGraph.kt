package com.awvgp.template.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.awvgp.template.feature.helloname.navigation.helloNameScreen
import com.awvgp.template.feature.helloname.navigation.navigateToHelloName
import com.awvgp.template.feature.nameinput.navigation.nameInputScreen

@Composable
fun SetupRoutes(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "name_input_route") {
        helloNameScreen() {

        }
        nameInputScreen() {
            navController.navigateToHelloName(it)
        }
    }
}