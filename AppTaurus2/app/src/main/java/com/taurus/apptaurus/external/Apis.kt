package com.taurus.apptaurus.external

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Apis {

    var BASE_URL = "http://44.205.157.25:8081/api/"

    fun getApiUsuarios(): ApiUsuarios {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL).build()

        return retrofit.create(ApiUsuarios::class.java)
    }

    fun getApiEntry(): ApiEntry{
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL).build()

        return retrofit.create(ApiEntry::class.java)
    }


}