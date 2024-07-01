package benhamida.jassem.domain.usecase.favorite_movies

import benhamida.jassem.domain.model.Movie
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow

interface GetFavoriteMoviesUseCase {
    suspend fun invoke(): Flow<PagingData<Movie>>
}