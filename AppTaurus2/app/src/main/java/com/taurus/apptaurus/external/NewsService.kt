package com.taurus.apptaurus.external

import com.taurus.apptaurus.response.NewsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface NewsService {

    @Headers("Content-Type: application/json")
    @GET("top-headlines")
    fun getNews(
        @Query("country") country: String,
        @Query("apiKey") apiKey: String,
        @Query("category") category: String
    ): Call<NewsResponse>
}