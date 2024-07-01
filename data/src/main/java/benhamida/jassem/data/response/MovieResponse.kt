package benhamida.jassem.data.response

import benhamida.jassem.data.entity.MovieEntity
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MovieResponse(
    val page: Int,
    @field:Json(name = "total_pages")
    val totalPages: Long,
    @field:Json(name = "total_results")
    val totalResults: Long,
    val results: List<MovieEntity>,
)