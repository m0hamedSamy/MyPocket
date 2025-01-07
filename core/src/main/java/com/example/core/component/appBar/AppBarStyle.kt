package com.example.core.component.appBar

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.mypocket.core.R

sealed interface AppBarStyle {
    data class DashboardAppBar(
        @StringRes val title: Int = R.string.app_name,
        @DrawableRes val icon: Int = R.drawable.ic_mypocket_logo,
        @StringRes val iconContentDesc: Int = R.string.app_name
    ) : AppBarStyle

    data class InnerScreenAppBar(
        @StringRes val title: Int,
        @DrawableRes val icon: Int = R.drawable.ic_back_arrow,
        @StringRes val iconContentDesc: Int = R.string.back_btn_content_desc,
        val onIconClicked: () -> Unit
    ) : AppBarStyle
}
