package benhamida.jassem.themoviedb.ui.screens.common

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector
import benhamida.jassem.themoviedb.R

sealed class BottomNavItem(val route: String, val icon: ImageVector, val labelRes: Int) {
    object Home : BottomNavItem("home", Icons.Filled.Home, R.string.home)
    object Favorite : BottomNavItem("favorite", Icons.Filled.Favorite, R.string.favorite)
}