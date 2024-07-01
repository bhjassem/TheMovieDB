package benhamida.jassem.themoviedb.ui.screens.details

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import benhamida.jassem.data.DataConstant
import benhamida.jassem.domain.model.MovieDetails
import benhamida.jassem.themoviedb.R
import benhamida.jassem.themoviedb.ui.screens.common.RatingBar
import coil3.compose.AsyncImagePainter
import coil3.compose.LocalPlatformContext
import coil3.compose.rememberAsyncImagePainter
import coil3.request.ImageRequest
import coil3.size.Size

@SuppressLint("OpaqueUnitKey")
@Composable
fun UIMovieDetails(movie: MovieDetails) {

    val posterImageState = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalPlatformContext.current)
            .data(DataConstant.IMAGE_BASE_URL + movie.posterPath)
            .size(Size.ORIGINAL)
            .build()
    ).state

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Box(
                modifier = Modifier
                    .width(160.dp)
                    .height(240.dp)
            ) {
                if (posterImageState is AsyncImagePainter.State.Error) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(RoundedCornerShape(8.dp))
                            .background(
                                MaterialTheme.colorScheme.primaryContainer
                            ), contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            modifier = Modifier.size(70.dp),
                            imageVector = Icons.Rounded.Info,
                            contentDescription = "PlaceHolder"
                        )
                    }
                } else if (posterImageState is AsyncImagePainter.State.Success) {
                    Image(
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(RoundedCornerShape(8.dp))
                            .height(240.dp),
                        painter = posterImageState.painter,
                        contentDescription = movie.title,
                        contentScale = ContentScale.Crop
                    )
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp)
            ) {
                Text(
                    text = movie.title,
                    fontSize = 19.sp,
                    fontWeight = FontWeight.SemiBold
                )

                Row(
                    modifier = Modifier
                        .padding(top = 16.dp)
                ) {
                    RatingBar(starsModifier = Modifier.size(18.dp), rating = movie.voteAverage / 2)
                    Text(
                        text = movie.voteAverage.toString().take(3),
                        modifier = Modifier.padding(start = 4.dp),
                        fontSize = 14.sp,
                        maxLines = 1
                    )
                }

                Text(
                    text = stringResource(id = R.string.original_language) + " " + movie.originalLanguage,
                    modifier = Modifier.padding(top = 10.dp)
                )

                Text(
                    text = stringResource(id = R.string.release_date) + " " + movie.releaseDate,
                    modifier = Modifier.padding(top = 10.dp)
                )

                Text(
                    text = movie.voteCount.toString() + " " + stringResource(id = R.string.vote),
                    modifier = Modifier.padding(top = 10.dp)
                )

                Text(
                    text = stringResource(id = R.string.budget) + " " + movie.budget.toString(),
                    modifier = Modifier.padding(top = 10.dp)
                )

                Text(
                    text = stringResource(id = R.string.revenue) + " " + movie.revenue.toString(),
                    modifier = Modifier.padding(top = 10.dp)
                )
            }
        }

        Text(
            text = stringResource(id = R.string.overview),
            fontSize = 19.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(start = 16.dp, top = 24.dp)
        )

        Text(
            text = movie.overview,
            fontSize = 16.sp,
            modifier = Modifier.padding(start = 16.dp, top = 8.dp, end = 16.dp)
        )

        Text(
            text = stringResource(id = R.string.companies),
            modifier = Modifier.padding(start = 16.dp, top = 24.dp, end = 16.dp)
        )

        LazyRow(
            state = rememberLazyListState(),
            modifier = Modifier
                .padding(start = 16.dp, top = 8.dp, bottom = 24.dp, end = 16.dp)
        ) {
            items(movie.productionCompanies.size) { index ->
                val item = movie.productionCompanies[index]
                UICompaniesItem(item)
            }
        }
    }
}