package benhamida.jassem.themoviedb.ui.screens.details

sealed class MovieDetailsIntent {
    data class GetMovieDetails(val movieId: Int) : MovieDetailsIntent()
    data class SetFavorite(val isFavorite: Boolean) : MovieDetailsIntent()
}