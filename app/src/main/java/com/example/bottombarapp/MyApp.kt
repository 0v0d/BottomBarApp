package com.example.bottombarapp

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@Composable
fun MyApp(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    val currentBackStack by navController.currentBackStackEntryAsState()
    val currentDestination = currentBackStack?.destination

    val currentScreen = tabRowScreens.find { it.route == currentDestination?.route } ?: Home
    Scaffold(
        modifier = modifier,
        bottomBar = {
            NavigationBarContent(
                navController = navController,
                currentScreen = currentScreen,
            )
        }
    ) {
        Box(modifier = Modifier.padding(it)) {
            NavHost(
                navController = navController,
                startDestination = Home.route,
                modifier = Modifier,
            ) {
                composable(route = Home.route) {
                    Home.screen()
                }
                composable(route = Search.route) {
                    Search.screen()
                }
                composable(route = Star.route) {
                    Star.screen()
                }
            }
        }
    }
}

@Composable
private fun NavigationBarContent(
    navController: NavHostController,
    currentScreen: Destination,
) {
    NavigationBar {
        tabRowScreens.forEach { screen ->
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = screen.icon,
                        contentDescription = screen.route,
                    )
                },
                label = { Text(text = screen.label) },
                selected = currentScreen == screen,
                onClick = {
                    navController.navigateSingleTopTo(screen.route)
                }
            )
        }
    }
}


fun NavHostController.navigateSingleTopTo(route: String) =
    this.navigate(route) {
        popUpTo(
            this@navigateSingleTopTo.graph.findStartDestination().id
        ) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }
