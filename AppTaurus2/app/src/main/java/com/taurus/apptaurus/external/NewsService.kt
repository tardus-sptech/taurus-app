package com.taurus.apptaurus.external

import com.taurus.apptaurus.request.News
import retrofit2.http.GET
import retrofit2.http.Headers

interface NewsService {

    @Headers("Content-Type: application/json")
    @GET("/top-headlines?country=pt&apiKey=6973c530c90647c8ac7221d9b3bcdfe6&category=business")
    fun getNews(): List<News>
}