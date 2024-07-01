package benhamida.jassem.domain.usecase.set_favorite

import benhamida.jassem.domain.model.MovieDetails


interface SetFavoriteUseCase {
    suspend fun invoke(movie: MovieDetails, favorite: Boolean)
}