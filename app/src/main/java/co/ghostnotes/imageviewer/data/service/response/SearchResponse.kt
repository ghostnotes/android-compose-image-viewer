package co.ghostnotes.imageviewer.data.service.response

import co.ghostnotes.imageviewer.data.entity.ItemEntity
import com.squareup.moshi.Json

data class SearchResponse(
    @Json(name = "items") val items: List<ItemEntity>
)
