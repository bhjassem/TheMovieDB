package benhamida.jassem.data.entity

import benhamida.jassem.domain.model.Genre
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NetworkGenre(
    val id: Int?,
    val name: String
)

fun NetworkGenre.asExternalModel() = Genre(
    id = id,
    name = name
)