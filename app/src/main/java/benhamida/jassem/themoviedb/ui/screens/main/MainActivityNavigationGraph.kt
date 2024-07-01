package benhamida.jassem.themoviedb.ui.screens.main

import android.view.WindowManager
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import benhamida.jassem.themoviedb.ui.screens.details.MovieDetailsScreen

const val MAIN_ROUTE = "main"
const val DETAILS_ROUTE = "details/{movieId}"
const val ARG_MOVIE_ID = "movieId"
@Composable
fun MainActivityNavigationGraph(
    activity: MainActivity,
    navController: NavHostController,
) {
    NavHost(
        modifier = Modifier.fillMaxSize(),
        navController = navController,
        startDestination = MAIN_ROUTE
    ) {
        composable(MAIN_ROUTE) {
            MainScreen { movieId ->
                activity.window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
                navController.navigateToDetails(movieId)
            }
        }
        composable(
            DETAILS_ROUTE,
            arguments = listOf(
                navArgument(ARG_MOVIE_ID) { type = NavType.IntType }
            )
        ) { navBackStackEntry ->
            MovieDetailsScreen(
                movieId = navBackStackEntry.arguments?.getInt(ARG_MOVIE_ID)?:0
            ) {
                navController.navigateUp()
            }
        }
    }
}


fun NavController.navigateToDetails(id: Int) {
    navigate("${DETAILS_ROUTE.split("/".toRegex()).first()}/$id")
}