package benhamida.jassem.domain.usecase.movie_details

import kotlinx.coroutines.flow.Flow

interface GetMovieDetailsUseCase {
    suspend fun invoke(id: Int): Flow<MovieDetailsRequestState>
}