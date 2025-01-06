package com.example.dashboard.nav

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.core.component.bottomNavBar.BottomNavBar
import kotlinx.serialization.Serializable

@Serializable
data object DashboardDestination

@Composable
fun DashboardGraph() {
    val navController = rememberNavController()
    val navItems = listOf(
        Home,
        Reports,
        Settings
    )

    Scaffold(
        bottomBar = {
            BottomNavBar(
                navController = navController,
                navItems = navItems
            )
        }
    ) { innerPadding ->
        NavHost(
            modifier = Modifier.padding(innerPadding),
            navController = navController,
            startDestination = Home
        ) {
            composable<Home> {  }
            composable<Reports> {  }
            composable<Settings> {  }
        }
    }
}