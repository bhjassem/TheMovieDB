package benhamida.jassem.data.entity

import benhamida.jassem.domain.model.BelongsToCollection
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NetworkBelongsToCollection(
    val id: Int,
    val name: String,
    @field:Json(name = "poster_path")
    val posterPath: String?,
    @field:Json(name = "backdrop_path")
    val backdropPath: String?,
)

fun NetworkBelongsToCollection.asExternalModel() = BelongsToCollection(
    id = id,
    name = name,
    posterPath = posterPath,
    backdropPath = backdropPath
)