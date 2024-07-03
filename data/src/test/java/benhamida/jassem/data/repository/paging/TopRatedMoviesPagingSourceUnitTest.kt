package benhamida.jassem.data.repository.paging

import androidx.paging.PagingSource
import benhamida.jassem.data.common.listOfMovieEntities
import benhamida.jassem.data.common.listOfMovies
import benhamida.jassem.data.datasource.MoviesDataSource
import benhamida.jassem.data.response.MovieResponse
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before
import org.junit.runner.RunWith
import org.junit.runners.JUnit4


@RunWith(JUnit4::class)
class TopRatedMoviesPagingSourceUnitTest {

    @MockK
    private lateinit var movieDataSource: MoviesDataSource
    private lateinit var topRatedMoviesPagingSource: TopRatedMoviesPagingSource

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        topRatedMoviesPagingSource = TopRatedMoviesPagingSource(movieDataSource)
    }

    @Test
    fun testTopRatedMoviesPagingSource_Positive() = runTest {

        coEvery { movieDataSource.getTopRatedMovies(1) } returns
                MovieResponse(1, 1, 1, listOfMovieEntities)


        val result = topRatedMoviesPagingSource.load(
            PagingSource.LoadParams.Refresh(key = null, loadSize = 1, placeholdersEnabled = false)
        )

        assertTrue(result is PagingSource.LoadResult.Page)
        val pageResult = result as PagingSource.LoadResult.Page
        assertEquals(listOfMovies, pageResult.data)
    }
}