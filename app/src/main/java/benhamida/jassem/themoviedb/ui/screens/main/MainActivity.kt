package benhamida.jassem.themoviedb.ui.screens.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import benhamida.jassem.themoviedb.ui.theme.TheMovieDBTheme
import androidx.compose.runtime.Composable
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            TheMovieDBTheme {
                MainApp(this)
            }
        }
    }
}

@Composable
fun MainApp(activity: MainActivity) {
    val navController = rememberNavController()
    MainActivityNavigationGraph(activity, navController)
}
