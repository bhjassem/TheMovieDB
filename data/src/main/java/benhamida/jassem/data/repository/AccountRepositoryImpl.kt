package benhamida.jassem.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import benhamida.jassem.data.datasource.AccountDataSource
import benhamida.jassem.data.datasource.PAGING_LIMIT
import benhamida.jassem.data.repository.paging.FavoriteMoviesPagingSource
import benhamida.jassem.domain.model.Movie
import benhamida.jassem.domain.model.MovieDetails
import benhamida.jassem.domain.repository.AccountRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class AccountRepositoryImpl @Inject constructor(
    private val favoritePagingDataSource: FavoriteMoviesPagingSource,
    private val accountDataSource: AccountDataSource
) : AccountRepository {

    override suspend fun getFavoriteMovies(): Flow<PagingData<Movie>> {
        return Pager(
            config = PagingConfig(pageSize = PAGING_LIMIT),
            pagingSourceFactory = {
                favoritePagingDataSource
            }
        ).flow
    }

    override suspend fun setFavorite(movie: MovieDetails, favorite: Boolean) {
        accountDataSource.setFavorite(movie, favorite)
    }
}