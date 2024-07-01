package benhamida.jassem.domain.usecase.movie_details

import benhamida.jassem.domain.model.MovieDetails


sealed class MovieDetailsRequestState {
    data object Loading : MovieDetailsRequestState()
    data class Success(val data: MovieDetails) : MovieDetailsRequestState()
    data class Exception(val code: Int = -1, val exception: Throwable) :
        MovieDetailsRequestState()
}