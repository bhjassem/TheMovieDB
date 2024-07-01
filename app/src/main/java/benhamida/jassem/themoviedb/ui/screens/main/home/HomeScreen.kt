package benhamida.jassem.themoviedb.ui.screens.main.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import benhamida.jassem.domain.model.Movie
import benhamida.jassem.themoviedb.ui.screens.common.AppLoader
import benhamida.jassem.themoviedb.ui.screens.common.MovieItem

@Composable
fun HomeScreen(
    onItemSelected: (Int) -> Unit,
    mainViewModel: HomeViewModel = hiltViewModel(),
) {
    val movieList: LazyPagingItems<Movie> =
        mainViewModel.topRatedMoviesListState.collectAsLazyPagingItems()

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {
        if (movieList.loadState.refresh is LoadState.Loading) {
            AppLoader()
        } else {
            LazyVerticalGrid(columns = GridCells.Fixed(2)) {
                items(movieList.itemCount) { movieItemIndex ->
                    val movie = movieList[movieItemIndex]
                    movie?.let { current ->
                        MovieItem(
                            movie = current
                        ) {
                            onItemSelected(movie.id)
                        }
                    }
                }
            }
        }
    }
}