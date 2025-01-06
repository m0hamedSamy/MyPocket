package com.example.core.component.bottomNavBar

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.core.extension.navigateSingleTop

@Composable
fun BottomNavBar(
    navController: NavHostController,
    navItems: List<BottomNavBarDestination>
) {
    NavigationBar {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        navItems.forEach { item ->
            val isSelected = currentDestination?.hierarchy?.any { it.hasRoute(item::class) } == true
            NavigationBarItem(
                colors = NavigationBarItemColors(
                    selectedIconColor = MaterialTheme.colorScheme.tertiary,
                    selectedTextColor = MaterialTheme.colorScheme.tertiary,
                    selectedIndicatorColor = MaterialTheme.colorScheme.surfaceContainer,
                    unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                    unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant,
                    disabledIconColor = MaterialTheme.colorScheme.secondaryContainer,
                    disabledTextColor = MaterialTheme.colorScheme.secondaryContainer,
                ),
                icon = {
                    Icon(
                        painter = painterResource(if(isSelected) item.selectedIcon else item.unselectedIcon),
                        contentDescription = item.toString(),
                    )
                },
                label = {
                    Text(
                        text = stringResource(id = item.label),
                        style = MaterialTheme.typography.bodySmall,
                    )
                },
                selected = isSelected,
                onClick = {
                    if(!isSelected) {
                        navController.navigateSingleTop(item)
                    }
                }
            )
        }
    }
}
