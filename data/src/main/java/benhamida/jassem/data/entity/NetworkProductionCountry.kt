package benhamida.jassem.data.entity

import benhamida.jassem.domain.model.ProductionCountry
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NetworkProductionCountry(
    @field:Json(name = "iso_3166_1")
    val iso31661: String,
    val name: String
)

fun NetworkProductionCountry.asExternalModel() = ProductionCountry(
    iso31661 = iso31661,
    name = name
)