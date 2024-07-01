package benhamida.jassem.themoviedb.ui.screens.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import benhamida.jassem.themoviedb.ui.screens.common.AppTopBar

@Composable
fun MovieDetailsScreen(
    movieId: Int,
    detailsViewModel: MovieDetailsViewModel = hiltViewModel(),
    onNavigateUp: () -> Unit
) {

    var isFavorite by remember { mutableStateOf(false) }

    val state by detailsViewModel.movieDetailsState.collectAsStateWithLifecycle()

    LaunchedEffect(key1 = Unit) {
        detailsViewModel.processIntent(MovieDetailsIntent.GetMovieDetails(movieId))
    }

    Scaffold(modifier = Modifier.fillMaxSize(),
        topBar = {
            AppTopBar(
                hasBackBtn = true,
                isFavorite = isFavorite,
                onBackBtnClicked = onNavigateUp,
                onFavoriteBtnClicked = {
                    detailsViewModel.processIntent(MovieDetailsIntent.SetFavorite(isFavorite))
                    isFavorite = !isFavorite
                }
            )
        }) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            when (state) {
                is DetailsUiState.Exception -> {
                    //TODO: handle errors...
                }

                DetailsUiState.Loading -> {
                    //TODO: handle Loading...
                }

                is DetailsUiState.Success -> {
                    val movieDetails = (state as DetailsUiState.Success).data
                    detailsViewModel.movieDetails = movieDetails
                    UIMovieDetails(movieDetails)
                }

                else -> {}
            }
        }
    }
}