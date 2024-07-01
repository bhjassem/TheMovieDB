package benhamida.jassem.domain.usecase.movie_details

import benhamida.jassem.domain.model.resource.ResultState
import benhamida.jassem.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

class GetMovieDetailsUseCaseImpl @Inject constructor(
    private val repository: MovieRepository
) : GetMovieDetailsUseCase {
    override suspend fun invoke(id: Int): Flow<MovieDetailsRequestState> {
        return flow {
            when (val response = repository.getMovieDetails(id)) {
                is ResultState.Success -> {
                    emit(MovieDetailsRequestState.Success(response.data))
                }
                is ResultState.Error -> {
                    emit(
                        MovieDetailsRequestState.Exception(
                            code = response.code,
                            exception = response.exception
                        )
                    )
                }
            }
        }.onStart {
            emit(MovieDetailsRequestState.Loading)
        }
    }
}