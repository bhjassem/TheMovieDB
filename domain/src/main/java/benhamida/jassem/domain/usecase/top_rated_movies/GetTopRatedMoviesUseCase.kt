package benhamida.jassem.domain.usecase.top_rated_movies

import benhamida.jassem.domain.model.Movie
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow

interface GetTopRatedMoviesUseCase {
    suspend fun invoke(): Flow<PagingData<Movie>>
}