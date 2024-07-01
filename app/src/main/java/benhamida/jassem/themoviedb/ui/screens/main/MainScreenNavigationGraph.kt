package benhamida.jassem.themoviedb.ui.screens.main

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import benhamida.jassem.themoviedb.ui.screens.common.BottomNavItem
import benhamida.jassem.themoviedb.ui.screens.main.favorite.FavoriteScreen
import benhamida.jassem.themoviedb.ui.screens.main.home.HomeScreen

@Composable
fun MainScreenNavigationGraph(
    onItemSelected: (Int) -> Unit,
    navController: NavHostController
) {
    NavHost(navController, startDestination = BottomNavItem.Home.route) {
        composable(BottomNavItem.Home.route) {
            HomeScreen(
                onItemSelected = onItemSelected
            )
        }
        composable(BottomNavItem.Favorite.route) {
            FavoriteScreen(
                onItemSelected = onItemSelected
            )
        }
    }
}