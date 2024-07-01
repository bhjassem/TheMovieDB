package benhamida.jassem.data.mapper

import benhamida.jassem.data.entity.MovieDetailsEntity
import benhamida.jassem.data.entity.asExternalModel
import benhamida.jassem.domain.model.MovieDetails

object MovieDetailsMapper : Mapper<MovieDetailsEntity, MovieDetails> {
    override fun map(data: MovieDetailsEntity): MovieDetails = MovieDetails(
        adult = data.adult,
        backdropPath = data.backdropPath,
        belongsToCollection = data.belongsToCollection?.asExternalModel(),
        budget = data.budget,
        genres = data.genres.map { it.asExternalModel() },
        homepage = data.homepage,
        id = data.id,
        imdbId = data.imdbId,
        originalLanguage = data.originalLanguage,
        originalTitle = data.originalTitle,
        overview = data.overview,
        popularity = data.popularity,
        posterPath = data.posterPath,
        productionCompanies = data.productionCompanies.map { it.asExternalModel() },
        productionCountries = data.productionCountries.map { it.asExternalModel() },
        releaseDate = data.releaseDate,
        revenue = data.revenue,
        runtime = data.runtime,
        spokenLanguages = data.spokenLanguages.map { it.asExternalModel() },
        status = data.status,
        tagline = data.tagline,
        title = data.title,
        video = data.video,
        voteAverage = data.voteAverage,
        voteCount = data.voteCount,
    )
}