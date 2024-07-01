package benhamida.jassem.themoviedb.ui.screens.details

import benhamida.jassem.domain.model.MovieDetails


sealed class DetailsUiState {
    data object Loading : DetailsUiState()
    data object Idle : DetailsUiState()
    data class Success(val data: MovieDetails) : DetailsUiState()
    data class Exception(val code: Int, val exception: Throwable) : DetailsUiState()
}