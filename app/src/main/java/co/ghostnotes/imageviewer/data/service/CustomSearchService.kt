package co.ghostnotes.imageviewer.data.service

import co.ghostnotes.imageviewer.BuildConfig
import co.ghostnotes.imageviewer.data.service.response.SearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CustomSearchService {
    @GET("v1?key=${BuildConfig.API_KEY}&cx=${BuildConfig.ENGINE_ID}&q=abstract+art&num=10")
    suspend fun searchImages(@Query("start") start: Int): SearchResponse
}