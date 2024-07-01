package benhamida.jassem.data.datasource

import benhamida.jassem.data.BuildConfig
import benhamida.jassem.data.api.AccountApi
import benhamida.jassem.data.response.MovieResponse
import benhamida.jassem.data.response.SetFavoriteResponse
import benhamida.jassem.domain.model.MovieDetails
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import javax.inject.Inject


class AccountDataSourceImpl @Inject constructor(
    private val api: AccountApi
) : AccountDataSource {

    override suspend fun getFavoriteMovies(page: Int): MovieResponse {
        return api.getFavoriteMovies(
            header = BuildConfig.TMDB_TOKEN,
            accountId = BuildConfig.ACCOUNT_ID,
            key = BuildConfig.API_KEY,
            page = page
        )
    }

    override suspend fun setFavorite(movie: MovieDetails, favorite: Boolean): SetFavoriteResponse {
        val gson: Gson = GsonBuilder()
            .serializeNulls()
            .disableHtmlEscaping()
            .create()

        val map = HashMap<String, Any>()
        map["media_type"] = "movie"
        map["media_id"] = movie.id
        map["favorite"] = favorite

        val requestBody: RequestBody = gson.toJson(map).toRequestBody("application/json".toMediaType())

        return api.setFavorite(
            header = BuildConfig.TMDB_TOKEN,
            accountId = BuildConfig.ACCOUNT_ID,
            key = BuildConfig.API_KEY,
            body = requestBody
        )
    }
}