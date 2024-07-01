package benhamida.jassem.data.entity

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MovieDetailsEntity(
    val adult: Boolean,
    @field:Json(name = "backdrop_path") val backdropPath: String?,
    @field:Json(name = "belongs_to_collection")
    val belongsToCollection: NetworkBelongsToCollection?,
    val budget: Int,
    val genres: List<NetworkGenre>,
    val homepage: String,
    val id: Int,
    @field:Json(name = "imdb_id")
    val imdbId: String,
    @field:Json(name = "original_language")
    val originalLanguage: String,
    @field:Json(name = "original_title")
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    @field:Json(name = "poster_path")
    val posterPath: String?,
    @field:Json(name = "production_companies")
    val productionCompanies: List<NetworkProductionCompany>,
    @field:Json(name = "production_countries")
    val productionCountries: List<NetworkProductionCountry>,
    @field:Json(name = "release_date")
    val releaseDate: String,
    val revenue: Int,
    val runtime: Int,
    @field:Json(name = "spoken_languages")
    val spokenLanguages: List<NetworkSpokenLanguage>,
    val status: String,
    val tagline: String,
    val title: String,
    val video: Boolean,
    @field:Json(name = "vote_average")
    val voteAverage: Double,
    @field:Json(name = "vote_count")
    val voteCount: Int,
)