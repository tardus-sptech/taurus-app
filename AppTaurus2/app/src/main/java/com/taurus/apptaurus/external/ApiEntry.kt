package com.taurus.apptaurus.external

import com.taurus.apptaurus.request.Gain
import com.taurus.apptaurus.request.GainRequest
import com.taurus.apptaurus.request.Spent
import com.taurus.apptaurus.request.SpentRequest
import com.taurus.apptaurus.response.CategoryResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiEntry {

    @Headers("Content-Type: application/json")
    @POST("/api/gains")
    fun GainResponse(@Body gainRequest: GainRequest): Call<Gain>

    @Headers("Content-Type: application/json")
    @POST("/api/spenties")
    fun SpentResponse(@Body spentRequest: SpentRequest): Call<Spent>
    @Headers("Content-Type: application/json")
    @GET("/api/categories")
    fun categoryResponse(): Call<List<CategoryResponse>>

}