package benhamida.jassem.domain.repository

import androidx.paging.PagingData
import benhamida.jassem.domain.model.Movie
import benhamida.jassem.domain.model.MovieDetails
import kotlinx.coroutines.flow.Flow

interface AccountRepository {

    suspend fun getFavoriteMovies(): Flow<PagingData<Movie>>

    suspend fun setFavorite(movie: MovieDetails, favorite: Boolean)
}