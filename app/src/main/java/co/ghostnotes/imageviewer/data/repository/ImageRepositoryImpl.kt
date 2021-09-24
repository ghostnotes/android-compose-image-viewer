package co.ghostnotes.imageviewer.data.repository

import co.ghostnotes.imageviewer.data.entity.getImageSrc
import co.ghostnotes.imageviewer.data.source.ImagesDataSource
import co.ghostnotes.imageviewer.domain.model.Image
import co.ghostnotes.imageviewer.domain.repository.ImageRepository
import co.ghostnotes.imageviewer.extensions.toData
import javax.inject.Inject

class ImageRepositoryImpl @Inject constructor(
    private val imagesDataSource: ImagesDataSource
) : ImageRepository {
    override suspend fun getImages(start: Int): List<Image> {
        return imagesDataSource.getImages(start)
            .filter { it.getImageSrc()?.isNotBlank() == true }
            .map { it.pagemap.cseImage!![0].toData() }
    }
}