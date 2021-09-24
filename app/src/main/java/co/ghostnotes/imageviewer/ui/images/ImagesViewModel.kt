package co.ghostnotes.imageviewer.ui.images

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.ghostnotes.imageviewer.domain.model.Image
import co.ghostnotes.imageviewer.domain.usecase.GetImagesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class ImagesViewModel @Inject constructor(
    private val getImagesUseCase: GetImagesUseCase
) : ViewModel() {

    private val _loading: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val loading: StateFlow<Boolean> = _loading

    private val _images: MutableStateFlow<List<Image>> = MutableStateFlow(emptyList())
    val images: StateFlow<List<Image>> = _images

    init {
        viewModelScope.launch {
            getImages()
        }
    }

    private suspend fun getImages() {
        _loading.value = true

        try {
            val imagesInternal = mutableListOf<Image>()
            listOf(2, 4, 8).forEach { imagesInternal += getImagesUseCase.execute(it) }

            _images.value = imagesInternal
            Timber.d("### images: $images, size=${images.value.size}")
        } catch (e: Exception) {
            Timber.e(e)

            // TODO handle error.
        } finally {
            _loading.value = false
        }
    }
}
