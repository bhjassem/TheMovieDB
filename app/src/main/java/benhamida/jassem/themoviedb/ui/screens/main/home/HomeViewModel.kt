package benhamida.jassem.themoviedb.ui.screens.main.home

import androidx.paging.PagingData
import androidx.paging.cachedIn
import benhamida.jassem.domain.model.Movie
import benhamida.jassem.domain.usecase.top_rated_movies.GetTopRatedMoviesUseCase
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getMovieListUseCase: GetTopRatedMoviesUseCase
) : ViewModel() {

    private val _topRatedMovieListState: MutableSharedFlow<PagingData<Movie>> =
        MutableStateFlow(value = PagingData.empty())

    val topRatedMoviesListState: SharedFlow<PagingData<Movie>> get() = _topRatedMovieListState

    init {
        viewModelScope.launch {
            getTopRatedMovies()
        }
    }

    private suspend fun getTopRatedMovies() {
        getMovieListUseCase.invoke()
            .distinctUntilChanged()
            .cachedIn(viewModelScope)
            .collect { movieListPagedData ->
                _topRatedMovieListState.emit(movieListPagedData)
            }
    }
}
