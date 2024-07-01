package benhamida.jassem.domain.repository

import androidx.paging.PagingData
import benhamida.jassem.domain.model.Movie
import benhamida.jassem.domain.model.MovieDetails
import benhamida.jassem.domain.model.resource.ResultState
import kotlinx.coroutines.flow.Flow

interface MovieRepository {

    suspend fun getTopRatedMovies(): Flow<PagingData<Movie>>

    suspend fun getMovieDetails(movieId: Int): ResultState<MovieDetails>
}