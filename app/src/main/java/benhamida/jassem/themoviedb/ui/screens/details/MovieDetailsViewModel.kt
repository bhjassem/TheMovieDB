package benhamida.jassem.themoviedb.ui.screens.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import benhamida.jassem.domain.model.MovieDetails
import benhamida.jassem.domain.usecase.movie_details.GetMovieDetailsUseCase
import benhamida.jassem.domain.usecase.movie_details.MovieDetailsRequestState
import benhamida.jassem.domain.usecase.set_favorite.SetFavoriteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    private val getMovieDetailsUseCase: GetMovieDetailsUseCase,
    private val setFavoriteUseCase: SetFavoriteUseCase
) : ViewModel() {

    private val _movieDetailsState: MutableStateFlow<DetailsUiState> =
        MutableStateFlow(DetailsUiState.Idle)

    val movieDetailsState: StateFlow<DetailsUiState> = _movieDetailsState.asStateFlow()

    var movieDetails: MovieDetails? = null


    fun processIntent(detailsIntent: MovieDetailsIntent) {
        if (detailsIntent is MovieDetailsIntent.GetMovieDetails) {
            getMovieDetails(detailsIntent.movieId)
        }
        when (detailsIntent) {
            is MovieDetailsIntent.GetMovieDetails -> {
                getMovieDetails(detailsIntent.movieId)
            }
            is MovieDetailsIntent.SetFavorite -> {
                movieDetails?.let {
                    setFavorite(it, detailsIntent.isFavorite)
                }
            }
        }
    }

    private fun getMovieDetails(movieId: Int) {
        viewModelScope.launch {
            getMovieDetailsUseCase.invoke(movieId).collect { detailsRequestState ->
                _movieDetailsState.value = when (detailsRequestState) {
                    is MovieDetailsRequestState.Exception -> DetailsUiState.Exception(
                        code = detailsRequestState.code,
                        exception = detailsRequestState.exception
                    )

                    is MovieDetailsRequestState.Success -> DetailsUiState.Success(
                        data = detailsRequestState.data
                    )

                    MovieDetailsRequestState.Loading -> DetailsUiState.Loading
                }
            }
        }
    }

    private fun setFavorite(movie: MovieDetails, favorite: Boolean) {
        viewModelScope.launch {
            setFavoriteUseCase.invoke(movie, favorite)
        }
    }
}