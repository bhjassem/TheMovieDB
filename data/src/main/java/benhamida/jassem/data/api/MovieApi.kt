package benhamida.jassem.data.api

import benhamida.jassem.data.entity.MovieDetailsEntity
import benhamida.jassem.data.response.MovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {

    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(
        @Query("page") page: Int = 1,
        @Query("api_key") key: String
    ): MovieResponse


    @GET("movie/{movieId}")
    suspend fun getMovieDetails(
        @Path("movieId") movieId: Int,
        @Query("api_key") key: String
    ): Response<MovieDetailsEntity>
}