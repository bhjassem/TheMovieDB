package benhamida.jassem.domain.usecase.set_favorite

import benhamida.jassem.domain.model.MovieDetails
import benhamida.jassem.domain.repository.AccountRepository
import javax.inject.Inject

class SetFavoriteUseCaseImpl @Inject constructor(
    private val repository: AccountRepository
) : SetFavoriteUseCase {

    override suspend fun invoke(movie: MovieDetails, favorite: Boolean){
        repository.setFavorite(movie, favorite)
    }
}