package benhamida.jassem.data.repository

import androidx.paging.PagingSource
import androidx.paging.map
import benhamida.jassem.data.common.listOfMovies
import benhamida.jassem.domain.model.Movie
import benhamida.jassem.domain.repository.AccountRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Test


class AccountRepositoryUnitTest {

    @Test
    fun `getFavoriteMovies emits PagingData with expected items`() = runTest {
        val repository = mockk<AccountRepository>()
        coEvery { repository.getFavoriteMovies() } returns flow {
            PagingSource.LoadResult.Page(
                listOfMovies, 1, 1
            )
        }

        val collectedItems = mutableListOf<Movie>()
        repository.getFavoriteMovies().collect { pagingData ->

            pagingData.map { item ->
                collectedItems.add(item)
            }

            assertNotNull(collectedItems)
            assertEquals(3, collectedItems.size)
        }
    }

    @Test
    fun `getFavoriteMovies emits PagingData with empty data`() = runTest {
        val repository = mockk<AccountRepository>()
        coEvery { repository.getFavoriteMovies() } returns flow {
            PagingSource.LoadResult.Page(
                listOf(), 1, 1
            )
        }

        val collectedItems = mutableListOf<Movie>()
        repository.getFavoriteMovies().collect { pagingData ->

            pagingData.map { item ->
                collectedItems.add(item)
            }

            assertNotNull(collectedItems)
            assertEquals(0, collectedItems.size)
        }
    }
}