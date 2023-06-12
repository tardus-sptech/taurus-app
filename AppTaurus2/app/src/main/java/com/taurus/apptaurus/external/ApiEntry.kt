package com.taurus.apptaurus.external

import com.taurus.apptaurus.request.Gain
import com.taurus.apptaurus.request.GainRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiEntry {

    @Headers("Content-Type: application/json")
    @POST("/api/spenties")
    fun GainResponse(@Body gainRequest: GainRequest): Call<Gain>

}