package benhamida.jassem.domain.di

import benhamida.jassem.domain.usecase.movie_details.GetMovieDetailsUseCase
import benhamida.jassem.domain.usecase.movie_details.GetMovieDetailsUseCaseImpl
import benhamida.jassem.domain.usecase.top_rated_movies.GetTopRatedMoviesUseCase
import benhamida.jassem.domain.usecase.top_rated_movies.GetTopRatedMoviesUseCaseImpl
import benhamida.jassem.domain.usecase.favorite_movies.GetFavoriteMoviesUseCase
import benhamida.jassem.domain.usecase.favorite_movies.GetFavoriteMoviesUseCaseImpl
import benhamida.jassem.domain.usecase.set_favorite.SetFavoriteUseCase
import benhamida.jassem.domain.usecase.set_favorite.SetFavoriteUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DomainModule {

    @Binds
    abstract fun bindsGetTopRatedMoviesUseCase(getMovieListUseCaseImpl: GetTopRatedMoviesUseCaseImpl): GetTopRatedMoviesUseCase

    @Binds
    abstract fun bindsGetMovieDetailsUseCase(getMovieDetailsUseCaseImpl: GetMovieDetailsUseCaseImpl): GetMovieDetailsUseCase

    @Binds
    abstract fun bindsGetFavoriteMoviesUseCase(getFavoriteMoviesUseCaseImpl: GetFavoriteMoviesUseCaseImpl): GetFavoriteMoviesUseCase

    @Binds
    abstract fun bindsGeStFavoriteUseCase(getFavoriteMoviesUseCaseImpl: SetFavoriteUseCaseImpl): SetFavoriteUseCase

}