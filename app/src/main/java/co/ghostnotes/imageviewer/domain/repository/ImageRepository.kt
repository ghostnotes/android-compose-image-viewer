package co.ghostnotes.imageviewer.domain.repository

import co.ghostnotes.imageviewer.domain.model.Image

interface ImageRepository {
    suspend fun getImages(start: Int): List<Image>
}
