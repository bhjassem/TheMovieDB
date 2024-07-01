package benhamida.jassem.themoviedb.ui.screens.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import benhamida.jassem.themoviedb.R
import benhamida.jassem.themoviedb.ui.theme.TheMovieDBTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(
    hasBackBtn: Boolean = false,
    isFavorite: Boolean = false,
    onBackBtnClicked: (() -> Unit)? = null,
    onFavoriteBtnClicked: (() -> Unit)? = null
) {
    CenterAlignedTopAppBar(
        title = {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = stringResource(id = R.string.app_name),
                contentScale = ContentScale.None,
                modifier = Modifier.fillMaxSize()
            )
        },
        navigationIcon = {
            if (hasBackBtn) {
                IconButton(onClick = { onBackBtnClicked?.invoke() }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "back"
                    )
                }
            }
        },
        actions = {
            if (hasBackBtn) {
                IconButton(onClick = { onFavoriteBtnClicked?.invoke() }) {
                    Icon(
                        imageVector = if(isFavorite) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder,
                        contentDescription = if (isFavorite) stringResource(id = R.string.remove_from_favorite) else stringResource(id = R.string.add_to_favorite)
                    )
                }
            }
        },
        scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    )
}

@Preview(apiLevel = 34)
@Composable
fun AppTopBarPreview() {
    TheMovieDBTheme {
        AppTopBar()
    }
}