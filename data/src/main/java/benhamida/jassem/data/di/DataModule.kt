package benhamida.jassem.data.di

import benhamida.jassem.data.datasource.MoviesDataSource
import benhamida.jassem.data.datasource.AccountDataSource
import benhamida.jassem.data.datasource.AccountDataSourceImpl
import benhamida.jassem.data.datasource.MoviesDataSourceImpl
import benhamida.jassem.data.repository.AccountRepositoryImpl
import benhamida.jassem.data.repository.MovieRepositoryImpl
import benhamida.jassem.domain.repository.AccountRepository
import benhamida.jassem.domain.repository.MovieRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    abstract fun bindsMoviesDataSource(moviesDataSourceImpl: MoviesDataSourceImpl)
            : MoviesDataSource

    @Binds
    abstract fun bindsAccountsDataSource(accountDataSourceImpl: AccountDataSourceImpl)
            : AccountDataSource

    @Binds
    abstract fun bindsAccountRepository(accountRepositoryImpl: AccountRepositoryImpl)
            : AccountRepository

    @Binds
    abstract fun bindsMoviesRepository(movieRepositoryImpl: MovieRepositoryImpl)
            : MovieRepository
}