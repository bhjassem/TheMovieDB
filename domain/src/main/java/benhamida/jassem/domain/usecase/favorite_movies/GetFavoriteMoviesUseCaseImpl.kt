package benhamida.jassem.domain.usecase.favorite_movies

import androidx.paging.PagingData
import benhamida.jassem.domain.model.Movie
import benhamida.jassem.domain.repository.AccountRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetFavoriteMoviesUseCaseImpl @Inject constructor(
    private val repository: AccountRepository
) : GetFavoriteMoviesUseCase {
    override suspend fun invoke(): Flow<PagingData<Movie>> {
        return repository.getFavoriteMovies()
    }
}