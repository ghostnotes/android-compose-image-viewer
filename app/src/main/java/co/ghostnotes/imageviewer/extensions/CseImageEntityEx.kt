package co.ghostnotes.imageviewer.extensions

import co.ghostnotes.imageviewer.data.entity.ItemEntity
import co.ghostnotes.imageviewer.domain.model.Image

fun ItemEntity.PagemapEntity.ImageEntity.toData(): Image = Image(src)
