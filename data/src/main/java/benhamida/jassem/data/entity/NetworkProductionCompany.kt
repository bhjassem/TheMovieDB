package benhamida.jassem.data.entity

import benhamida.jassem.domain.model.ProductionCompany
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NetworkProductionCompany(
    val id: Int,
    val name: String,
    @field:Json(name = "logo_path")
    val logoPath: String?,
    @field:Json(name = "origin_country")
    val originCountry: String,
)

fun NetworkProductionCompany.asExternalModel() = ProductionCompany(
    id = id,
    name = name,
    logoPath = logoPath,
    originCountry = originCountry
)