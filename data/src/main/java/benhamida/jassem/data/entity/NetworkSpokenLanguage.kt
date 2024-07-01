package benhamida.jassem.data.entity


import benhamida.jassem.domain.model.SpokenLanguage
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NetworkSpokenLanguage(
    @field:Json(name = "english_name")
    val englishName: String,
    @field:Json(name = "iso_639_1")
    val iso6391: String,
    val name: String,
)

fun NetworkSpokenLanguage.asExternalModel() = SpokenLanguage(
    englishName = englishName,
    iso6391 = iso6391,
    name = name
)