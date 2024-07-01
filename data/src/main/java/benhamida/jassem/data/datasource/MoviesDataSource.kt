package benhamida.jassem.data.datasource

import benhamida.jassem.data.response.MovieResponse
import benhamida.jassem.domain.model.MovieDetails
import benhamida.jassem.domain.model.resource.ResultState

interface MoviesDataSource {

    suspend fun getTopRatedMovies(page: Int): MovieResponse

    suspend fun getMovieDetails(movieId: Int): ResultState<MovieDetails>
}