package benhamida.jassem.data.repository.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import benhamida.jassem.data.datasource.AccountDataSource
import benhamida.jassem.data.mapper.MovieMapper
import benhamida.jassem.domain.model.Movie
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject


class FavoriteMoviesPagingSource @Inject constructor(
    private val favoriteMoviesDataSource: AccountDataSource
) : PagingSource<Int, Movie>() {

    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        return try {
            val currentPage = params.key ?: 1
            val movies = favoriteMoviesDataSource.getFavoriteMovies(currentPage)
            LoadResult.Page(
                data = movies.results.map { MovieMapper.map(it) },
                prevKey = if (currentPage == 1) null else currentPage - 1,
                nextKey = if (movies.results.isEmpty()) null else currentPage + 1
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }

}