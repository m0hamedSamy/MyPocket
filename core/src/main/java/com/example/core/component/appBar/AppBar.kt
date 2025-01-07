package com.example.core.component.appBar

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@Composable
fun AppBar(
    appBarStyle: AppBarStyle
) {
    when(appBarStyle) {
        is AppBarStyle.DashboardAppBar -> DashboardAppBar(appBarStyle = appBarStyle)
        is AppBarStyle.InnerScreenAppBar -> InnerScreenAppBar(appBarStyle = appBarStyle)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun DashboardAppBar(appBarStyle: AppBarStyle.DashboardAppBar) {
    TopAppBar(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .padding(vertical = 10.dp),
        title = {
            Text(
                modifier = Modifier.padding(start = 10.dp),
                text = stringResource(appBarStyle.title),
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Light,
                color = MaterialTheme.colorScheme.onSurface,
                maxLines = 1,
                overflow = TextOverflow. Ellipsis,
                textAlign = TextAlign.Center
            )
        },
        navigationIcon = {
            Image(
                modifier = Modifier.size(40.dp),
                painter = painterResource(appBarStyle.icon),
                contentDescription = stringResource(appBarStyle.iconContentDesc)
            )
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun InnerScreenAppBar(appBarStyle: AppBarStyle.InnerScreenAppBar) {
    CenterAlignedTopAppBar(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .padding(vertical = 10.dp),
        title = {
            Text(
                modifier = Modifier.padding(start = 10.dp),
                text = stringResource(appBarStyle.title),
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Light,
                color = MaterialTheme.colorScheme.onSurface,
                maxLines = 1,
                overflow = TextOverflow. Ellipsis,
                textAlign = TextAlign.Center
            )
        },
        navigationIcon = {
            Icon(
                modifier = Modifier
                    .size(25.dp)
                    .clickable(
                        indication = null,
                        interactionSource = remember { MutableInteractionSource() }
                    ) { appBarStyle.onIconClicked() },
                painter = painterResource(appBarStyle.icon),
                contentDescription = stringResource(appBarStyle.iconContentDesc)
            )
        }
    )
}