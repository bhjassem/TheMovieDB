package benhamida.jassem.themoviedb.ui.screens.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import benhamida.jassem.themoviedb.ui.screens.common.AppTopBar
import benhamida.jassem.themoviedb.ui.screens.common.BottomBar

@Composable
fun MainScreen(
    onItemSelected: (Int) -> Unit
) {
    val navController = rememberNavController()

    Scaffold(
        topBar = {
            AppTopBar()
        },
        bottomBar = {
            BottomBar(
                modifier = Modifier,
                navController = navController
            )
        },
        modifier = Modifier.fillMaxSize(),
    ) { innerPaddings ->
        Box(
            modifier = Modifier.padding(innerPaddings)
        ) {
            MainScreenNavigationGraph(
                onItemSelected = onItemSelected,
                navController = navController
            )
        }
    }
}
