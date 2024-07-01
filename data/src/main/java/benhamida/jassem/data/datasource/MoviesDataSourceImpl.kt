package benhamida.jassem.data.datasource

import benhamida.jassem.data.BuildConfig
import benhamida.jassem.data.api.MovieApi
import benhamida.jassem.data.mapper.MovieDetailsMapper
import benhamida.jassem.data.response.MovieResponse
import benhamida.jassem.data.response.handleApiResponse
import benhamida.jassem.domain.model.MovieDetails
import benhamida.jassem.domain.model.resource.ResultState
import javax.inject.Inject

const val PAGING_LIMIT = 20

class MoviesDataSourceImpl @Inject constructor(
    private val api: MovieApi
) : MoviesDataSource {

    override suspend fun getTopRatedMovies(page: Int): MovieResponse {
        return api.getTopRatedMovies(
            page = page,
            BuildConfig.API_KEY
        )
    }

    override suspend fun getMovieDetails(movieId: Int): ResultState<MovieDetails> {
        return handleApiResponse(mapper = MovieDetailsMapper) {
            api.getMovieDetails(movieId, BuildConfig.API_KEY)
        }
    }
}