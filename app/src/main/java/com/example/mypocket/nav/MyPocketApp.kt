package com.example.mypocket.nav

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.dashboard.nav.DashboardDestination
import com.example.dashboard.nav.DashboardGraph

@Composable
fun MyPocketApp() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = DashboardDestination
    ) {
        composable<DashboardDestination> {
            DashboardGraph()
        }
    }
}