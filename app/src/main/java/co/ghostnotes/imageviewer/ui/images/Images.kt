package co.ghostnotes.imageviewer.ui.images

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import co.ghostnotes.imageviewer.R
import co.ghostnotes.imageviewer.domain.model.Image
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import timber.log.Timber

@ExperimentalCoilApi
@ExperimentalFoundationApi
@Composable
fun Images(imagesViewModel: ImagesViewModel) {
    Timber.d("### size=${imagesViewModel.images.value.size}")
    val loading = imagesViewModel.loading.collectAsState()

    Box(modifier = Modifier.fillMaxSize()) {
        ImageList(imagesViewModel)

        if (loading.value) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}

@ExperimentalCoilApi
@ExperimentalFoundationApi
@Composable
fun ImageList(imagesViewModel: ImagesViewModel) {
    val images = imagesViewModel.images.collectAsState()
    ImageList(images.value)
}

@ExperimentalCoilApi
@ExperimentalFoundationApi
@Composable
fun ImageList(images: List<Image>) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(3),
        contentPadding = PaddingValues(8.dp),
        content = {
            items(images.size) { index ->
                PlaceHolderImage()
                ImageInternal(image = images[index])
            }
        }
    )
}

@ExperimentalCoilApi
@Composable
fun ImageInternal(image: Image) {
    val painter = rememberImagePainter(
        data = image.src,
        onExecute = { _, _ -> true },
        builder = {
            crossfade(true)
        }
    )
    Image(
        modifier = Modifier.aspectRatio(1F),
        painter = painter,
        contentDescription = "",
        contentScale = ContentScale.Crop,
    )
} 

@Composable
fun PlaceHolderImage() {
    Image(
        modifier = Modifier.aspectRatio(1F),
        contentDescription = "",
        contentScale = ContentScale.None,
        painter = painterResource(id = R.drawable.ic_image),
    )
}
