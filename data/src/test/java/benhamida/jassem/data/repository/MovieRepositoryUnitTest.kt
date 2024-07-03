package benhamida.jassem.data.repository

import androidx.paging.PagingSource
import androidx.paging.map
import benhamida.jassem.data.common.listOfMovies
import benhamida.jassem.data.common.movie123Details
import benhamida.jassem.data.common.movie123ID
import benhamida.jassem.data.common.movie123Title
import benhamida.jassem.domain.model.Movie
import benhamida.jassem.domain.model.resource.ResultState
import benhamida.jassem.domain.repository.MovieRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Test


class MovieRepositoryUnitTest {

    @Test
    fun `getTopRatedMovies emits PagingData with expected items`() = runTest {
        val repository = mockk<MovieRepository>()
        coEvery { repository.getTopRatedMovies() } returns flow {
            PagingSource.LoadResult.Page(
                listOfMovies, 1, 1
            )
        }

        val collectedItems = mutableListOf<Movie>()
        repository.getTopRatedMovies().collect { pagingData ->

            pagingData.map { item ->
                collectedItems.add(item)
            }

            assertNotNull(collectedItems)
            assertEquals(3, collectedItems.size)
        }
    }

    @Test
    fun `getTopRatedMovies emits PagingData with empty data`() = runTest {
        val repository = mockk<MovieRepository>()
        coEvery { repository.getTopRatedMovies() } returns flow {
            PagingSource.LoadResult.Page(
                listOf(), 1, 1
            )
        }

        val collectedItems = mutableListOf<Movie>()
        repository.getTopRatedMovies().collect { pagingData ->

            pagingData.map { item ->
                collectedItems.add(item)
            }

            assertNotNull(collectedItems)
            assertEquals(0, collectedItems.size)
        }
    }


    @Test
    fun `getMovieDetails returns ResultState Success with expected item`() = runTest {
        val repository = mockk<MovieRepository>()
        coEvery { repository.getMovieDetails(movie123ID) } returns ResultState.Success(movie123Details)
        val result = repository.getMovieDetails(movie123ID)

        assertNotNull(result)
        assertTrue(result is ResultState.Success)
        assertEquals((result as ResultState.Success).data.id, movie123ID)
        assertEquals(result.data.title, movie123Title)
    }


    @Test
    fun `getMovieDetails returns ResultState Error`() = runTest {
        val repository = mockk<MovieRepository>()
        coEvery { repository.getMovieDetails(-1) } returns ResultState.Error(-1, Throwable("error"))
        val result = repository.getMovieDetails(-1)

        assertNotNull(result)
        assertTrue(result is ResultState.Error)
        assertEquals((result as ResultState.Error).code, -1)
    }
}