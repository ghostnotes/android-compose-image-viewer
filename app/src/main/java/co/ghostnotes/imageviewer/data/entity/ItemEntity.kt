package co.ghostnotes.imageviewer.data.entity

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ItemEntity(
    @Json(name = "pagemap") val pagemap: PagemapEntity,
) {
    @JsonClass(generateAdapter = true)
    data class PagemapEntity(
        @Json(name = "cse_image") val cseImage: List<ImageEntity>? = null,
    ) {
        @JsonClass(generateAdapter = true)
        data class ImageEntity(
            @Json(name = "src") val src: String,
        )
    }
}

fun ItemEntity.getImageSrc(): String? {
    return pagemap.cseImage?.let {
        if (it.isNotEmpty()) {
            it[0].src
        } else {
            null
        }
    }
}

/*
    {
      "kind": "customsearch#result",
      "title": "Abstract art - Wikipedia",
      "htmlTitle": "\u003cb\u003eAbstract art\u003c/b\u003e - Wikipedia",
      "link": "https://en.wikipedia.org/wiki/Abstract_art",
      "displayLink": "en.wikipedia.org",
      "snippet": "Abstract art uses visual language of shape, form, color and line to create a composition which may exist with a degree of independence from visual ...",
      "htmlSnippet": "\u003cb\u003eAbstract art\u003c/b\u003e uses visual language of shape, form, color and line to create a composition which may exist with a degree of independence from visual&nbsp;...",
      "cacheId": "XYGB26_CaRsJ",
      "formattedUrl": "https://en.wikipedia.org/wiki/Abstract_art",
      "htmlFormattedUrl": "https://en.wikipedia.org/wiki/\u003cb\u003eAbstract\u003c/b\u003e_\u003cb\u003eart\u003c/b\u003e",
      "pagemap": {
        "cse_thumbnail": [
          {
            "src": "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcT6Tm7beXJC9KNJ7kVR3ghvCJDO97VFk5hB7PLdjzGPb4LMkzaC0HVLNddE",
            "width": "224",
            "height": "225"
          }
        ],
        "metatags": [
          {
            "referrer": "origin",
            "og:image": "https://upload.wikimedia.org/wikipedia/commons/6/63/Robert_Delaunay%2C_1913%2C_Premier_Disque%2C_134_cm%2C_52.7_inches%2C_Private_collection.jpg",
            "og:type": "website",
            "og:title": "Abstract art - Wikipedia",
            "format-detection": "telephone=no"
          }
        ],
        "cse_image": [
          {
            "src": "https://upload.wikimedia.org/wikipedia/commons/6/63/Robert_Delaunay%2C_1913%2C_Premier_Disque%2C_134_cm%2C_52.7_inches%2C_Private_collection.jpg"
          }
        ]
      }
    },
 */