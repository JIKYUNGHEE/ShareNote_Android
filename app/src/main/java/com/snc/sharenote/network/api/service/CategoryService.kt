package com.snc.sharenote.network.api.service

import com.snc.sharenote.network.data.CategoryResource
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface CategoryService {
    @GET("category")
    fun category(@Header("Authorization") token: String): Call<CategoryResource>

    @GET("category/detail")
    fun categoryDetail(@Header("Authorization") token: String): Call<CategoryResource>

    @GET("category/detail/{category_num}")
    fun categoryDetailByNum(
        @Header("Authorization") token: String,
        @Path("category_num") num: String
    ): Call<CategoryResource>

    @GET("category/{category_keyword}")
    fun categorySearch(
        @Header("Authorization") token: String,
        @Path("category_keyword") keyword: String
    ): Call<CategoryResource>

    @GET("category/top10")
    fun categoryTop10(@Header("Authorization") token: String): Call<CategoryResource>
}