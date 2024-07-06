package com.example.bottombarapp

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.bottombarapp.ui.home.HomeScreen
import com.example.bottombarapp.ui.search.SearchScreen
import com.example.bottombarapp.ui.star.StarScreen

interface Destination {
    val icon: ImageVector
    val route: String
    val screen: @Composable () -> Unit
}

object Home : Destination {
    override val icon = Icons.Default.Home
    override val route = "home"
    override val screen: @Composable () -> Unit = { HomeScreen() }
}

object Search : Destination {
    override val icon = Icons.Default.Search
    override val route = "search"
    override val screen: @Composable () -> Unit = { SearchScreen() }
}

object Star : Destination {
    override val icon = Icons.Default.Star
    override val route = "star"
    override val screen: @Composable () -> Unit = { StarScreen() }
}

val tabRowScreens = listOf(Home, Search, Star)

