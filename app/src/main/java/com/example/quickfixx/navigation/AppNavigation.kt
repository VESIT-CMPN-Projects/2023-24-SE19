package com.example.quickfixx.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.quickfixx.screens.auth.ElectricianData
import com.example.quickfixx.screens.auth.HomePage
import com.example.quickfixx.screens.auth.SignUpScreen
import com.example.quickfixx.WelcomePage.WelcomePageScreen
import com.example.quickfixx.screens.auth.OTPScreen1
import com.example.quickfixx.screens.auth.OTPScreen2
import com.example.quickfixx.screens.auth.CustomerSupport
import com.example.quickfixx.screens.auth.LoginScreen
import com.example.quickfixx.screens.auth.VisitorsScreen

/*
* Route in case you use Enums: route = QFScreens.WelcomePageScreen.name
* Route in case you use Sealed class: route = Screens.WelcomePageScreen.route
* */


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screens.WelcomePageScreen.route) {

        composable(route = Screens.WelcomePageScreen.route) {
            WelcomePageScreen(navController)
        }

        composable(route = Screens.LoginScreen.route) {
            LoginScreen(navController)
        }
        composable(route = Screens.SignUpScreen.route) {
            SignUpScreen(navController)
        }
        composable(route = Screens.OTPScreen1.route) {
            OTPScreen1(navController)
        }
        composable(route = Screens.OTPScreen2.route) {
            OTPScreen2(navController)
        }
        composable(route = Screens.HomePage.route) {
            HomePage(navController)
        }
//        composable(route = Screens.ElectricianData.route) {
//            ElectricianData(navController)
//        }
        composable(route = Screens.CustomerSupport.route) {
            CustomerSupport(navController)
        }
        composable(route = Screens.VisitorsScreen.route) {
            VisitorsScreen()
        }

//        composable(route = Screens.Navtest.route) {
//            Navtest(navController)
//        }
    }
}

