package benhamida.jassem.data.common

import benhamida.jassem.data.entity.MovieEntity
import benhamida.jassem.domain.model.Movie
import benhamida.jassem.domain.model.MovieDetails

val genreId: List<Int> = listOf(1, 2, 3)
val movie1 = Movie(
    1,
    false,
    "string1",
    genreId,
    "en",
    "Hi",
    "hello",
    3.4,
    "test1",
    "test2",
    "test1",
    false,
    2.3,
    2
)
val movie2 = Movie(
    2,
    false,
    "string1",
    genreId,
    "en",
    "Hello",
    "hello",
    3.4,
    "test1",
    "test2",
    "test1",
    false,
    2.3,
    2
)
val movie3 = Movie(
    3,
    false,
    "string1",
    genreId,
    "en",
    "Bye",
    "hello",
    3.4,
    "test1",
    "test2",
    "test1",
    true,
    4.3,
    2
)
val movieEntity1 = MovieEntity(
    1,
    false,
    "string1",
    genreId,
    "en",
    "Hi",
    "hello",
    3.4,
    "test1",
    "test2",
    "test1",
    false,
    2.3,
    2
)
val movieEntity2 = MovieEntity(
    2,
    false,
    "string1",
    genreId,
    "en",
    "Hello",
    "hello",
    3.4,
    "test1",
    "test2",
    "test1",
    false,
    2.3,
    2
)
val movieEntity3 = MovieEntity(
    3,
    false,
    "string1",
    genreId,
    "en",
    "Bye",
    "hello",
    3.4,
    "test1",
    "test2",
    "test1",
    true,
    4.3,
    2
)

val listOfMovies = listOf(movie1, movie2, movie3)
val listOfMovieEntities = listOf(movieEntity1, movieEntity2, movieEntity3)


const val movie123Title = "Joker"
const val movie123ID = 123
val movie123Details = MovieDetails(
    false,
    "string1",
    null,
    1,
    listOf(),
    "en",
    movie123ID,
    "hello",
    "en",
    movie123Title,
    "test2",
    2.2,
    "test",
    listOf(),
    listOf(),
    "test",
    2,
    2,
    listOf(), "test",
    "test",
    movie123Title,
    false,
    2.2,
    1
)