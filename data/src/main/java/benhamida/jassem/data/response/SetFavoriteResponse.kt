package benhamida.jassem.data.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SetFavoriteResponse(
    val success: Boolean,
    @field:Json(name = "status_code")
    val statusCode: Long,
    @field:Json(name = "status_message")
    val statusMessage: String
)