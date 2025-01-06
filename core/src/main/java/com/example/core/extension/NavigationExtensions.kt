package com.example.core.extension

import androidx.navigation.NavController

fun NavController.navigateSingleTop(route: Any) {
    navigate(route) {
        popUpTo(graph.startDestinationId) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }
}