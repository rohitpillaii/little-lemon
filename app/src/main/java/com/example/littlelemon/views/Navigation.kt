package com.example.littlelemon.views

import android.content.Context
import androidx.compose.runtime.Composable

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable


@Composable
fun Navigation(navController: NavHostController, context: Context) {

    NavHost(
        navController = navController,
        startDestination = if (isUserOnboarded(context)) HomeDestination.route else OnBoardingDestination.route
    ) {
        composable(HomeDestination.route) { Home(navController) }
        composable(ProfileDestination.route) { Profile(navController) }
        composable(OnBoardingDestination.route) { OnBoarding(navController) }
    }
}

// Helper function to check if user isonboarded (replace with your actual logic)
private fun isUserOnboarded(context: Context): Boolean {
    val sharedPreferences = context.getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
    return sharedPreferences.getBoolean("onboarded", false)
}