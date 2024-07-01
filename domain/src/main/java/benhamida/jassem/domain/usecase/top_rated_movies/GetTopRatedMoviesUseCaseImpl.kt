package benhamida.jassem.domain.usecase.top_rated_movies

import androidx.paging.PagingData
import benhamida.jassem.domain.model.Movie
import benhamida.jassem.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTopRatedMoviesUseCaseImpl @Inject constructor(
    private val repository: MovieRepository
) : GetTopRatedMoviesUseCase {
    override suspend fun invoke(): Flow<PagingData<Movie>> {
        return repository.getTopRatedMovies()
    }
}