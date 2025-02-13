package com.development.enoturismecatalunya.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.development.core.designsystem.components.scaffold.ScaffoldState
import com.development.dos.presentation.api.NavRoute
import com.development.dos.presentation.api.DoDetailScreen
import com.development.dos.presentation.api.DoListScreen

@Composable
fun NavigationWrapper(
    scaffoldState: ScaffoldState,
) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = NavRoute.DoList
    ) {
        composable<NavRoute.DoList> {
            DoListScreen(
                scaffoldState = scaffoldState,
                onDoSelected = { navController.navigate(NavRoute.DoDetail(it)) }
            )
        }
        composable<NavRoute.DoDetail> {
            DoDetailScreen(
                scaffoldState = scaffoldState,
                onBack = { navController.navigateUp() },
                onCellarClick = { navController.navigate(NavRoute.CellarDetail(it)) }
            )
        }
    }
}
