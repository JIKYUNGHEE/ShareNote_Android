package com.snc.sharenote.network

import HALConverterFactory
import com.google.gson.GsonBuilder
import com.snc.sharenote.network.data.response.ResponseDefault
import retrofit2.Retrofit

object RetrofitClient {
    private var instance : Retrofit ? = null
    private val gson = GsonBuilder().setLenient().create()
    private const val BASE_URL = "http://52.79.246.196:8083";

    fun getInstance() : Retrofit {
        if(instance == null) {
            instance = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(HALConverterFactory.create(ResponseDefault::class.java))
                .build()
        }

        return instance!!
    }
}