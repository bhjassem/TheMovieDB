package benhamida.jassem.data.datasource

import benhamida.jassem.data.response.MovieResponse
import benhamida.jassem.data.response.SetFavoriteResponse
import benhamida.jassem.domain.model.MovieDetails

interface AccountDataSource {

    suspend fun getFavoriteMovies(page: Int): MovieResponse

    suspend fun setFavorite(movie: MovieDetails, favorite: Boolean): SetFavoriteResponse
}