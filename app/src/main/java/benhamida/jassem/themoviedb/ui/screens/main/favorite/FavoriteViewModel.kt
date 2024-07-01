package benhamida.jassem.themoviedb.ui.screens.main.favorite

import androidx.paging.PagingData
import androidx.paging.cachedIn
import benhamida.jassem.domain.model.Movie
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import benhamida.jassem.domain.usecase.favorite_movies.GetFavoriteMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val getFavoriteMoviesUseCase: GetFavoriteMoviesUseCase
) : ViewModel() {
    private val _favoriteMoviesListState: MutableStateFlow<PagingData<Movie>> =
        MutableStateFlow(value = PagingData.empty())

    val favoriteMoviesListState: MutableStateFlow<PagingData<Movie>> get() = _favoriteMoviesListState

    init {
        viewModelScope.launch {
            getFavoritesMovies()
        }
    }

    private suspend fun getFavoritesMovies() {
        getFavoriteMoviesUseCase.invoke()
            .distinctUntilChanged()
            .cachedIn(viewModelScope)
            .collect { movieListPagedData ->
                _favoriteMoviesListState.value = movieListPagedData
            }
    }
}