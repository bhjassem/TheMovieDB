package benhamida.jassem.data.api

import benhamida.jassem.data.response.MovieResponse
import benhamida.jassem.data.response.SetFavoriteResponse
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface AccountApi {

    @GET("account/{account_id}/favorite/movies")
    suspend fun getFavoriteMovies(
        @Header("Authorization") header: String,
        @Path("account_id") accountId: String,
        @Query("api_key") key: String,
        @Query("page") page: Int
    ): MovieResponse


    @Headers("Content-Type: application/json")
    @POST("account/{account_id}/favorite")
    suspend fun setFavorite(
        @Header("Authorization") header: String,
        @Path("account_id") accountId: String,
        @Query("api_key") key: String,
        @Body body: RequestBody
    ): SetFavoriteResponse
}