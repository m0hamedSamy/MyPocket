package com.example.dashboard.nav

import com.example.core.component.bottomNavBar.BottomNavBarDestination
import com.example.mypocket.dashboard.R
import kotlinx.serialization.Serializable

@Serializable
internal data object Home : BottomNavBarDestination(
    label = R.string.bottom_nav_btn_home,
    selectedIcon = R.drawable.ic_home_filled,
    unselectedIcon = R.drawable.ic_home_outlined
)

@Serializable
internal data object Reports : BottomNavBarDestination(
    label = R.string.bottom_nav_btn_reports,
    selectedIcon = R.drawable.ic_reports_filled,
    unselectedIcon = R.drawable.ic_reports_outlined
)

@Serializable
internal data object Settings : BottomNavBarDestination(
    label = R.string.bottom_nav_btn_settings,
    selectedIcon = R.drawable.ic_settings_filled,
    unselectedIcon = R.drawable.ic_settings_outlined
)