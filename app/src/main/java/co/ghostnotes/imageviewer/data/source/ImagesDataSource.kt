package co.ghostnotes.imageviewer.data.source

import co.ghostnotes.imageviewer.data.entity.ItemEntity
import co.ghostnotes.imageviewer.data.service.CustomSearchService
import javax.inject.Inject

class ImagesDataSource @Inject constructor(
    private val customSearchService: CustomSearchService
) {
    suspend fun getImages(start: Int): List<ItemEntity> {
        return customSearchService.searchImages(start).items
    }
}