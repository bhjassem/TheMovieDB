package benhamida.jassem.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import benhamida.jassem.data.datasource.PAGING_LIMIT
import benhamida.jassem.data.datasource.MoviesDataSource
import benhamida.jassem.data.repository.paging.TopRatedMoviesPagingSource
import benhamida.jassem.domain.model.Movie
import benhamida.jassem.domain.model.MovieDetails
import benhamida.jassem.domain.model.resource.ResultState
import benhamida.jassem.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


private const val PREFETCH_DISTANCE = 50

class MovieRepositoryImpl @Inject constructor(
    private val topRatedMoviesPagingSource: TopRatedMoviesPagingSource,
    private val movieDataSource: MoviesDataSource
) : MovieRepository {

    override suspend fun getTopRatedMovies(): Flow<PagingData<Movie>> {
        return Pager(
            config = PagingConfig(pageSize = PAGING_LIMIT, prefetchDistance = PREFETCH_DISTANCE),
            pagingSourceFactory = {
                topRatedMoviesPagingSource
            }
        ).flow
    }

    override suspend fun getMovieDetails(movieId: Int): ResultState<MovieDetails> {
        return movieDataSource.getMovieDetails(movieId)
    }
}