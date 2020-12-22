package com.snc.sharenote.network

import HALConverterFactory
import com.google.gson.GsonBuilder
import com.snc.sharenote.network.data.Member
import retrofit2.Retrofit

object RetrofitClient {
    private var instance: Retrofit? = null
    private val gson = GsonBuilder().setLenient().create()
    private const val BASE_API_URL = "http://52.79.246.196:8083/api/rest/";

    fun getInstance(): Retrofit {
        if (instance == null) {
            instance = Retrofit.Builder()
                .baseUrl(BASE_API_URL)
//                .addConverterFactory(HALConverterFactory.create(ResponseDefault::class.java))
                .addConverterFactory(HALConverterFactory.create(Member::class.java))    //TODO. Converter 여러개 사용해도 에러 안나게
//                .addConverterFactory(HALConverterFactory.create(CategoryResource::class.java))
                .build()
        }

        return instance!!
    }
}