package com.snc.sharenote.network.api.service

import com.snc.sharenote.network.data.Tag
import com.snc.sharenote.network.data.TagResource
import retrofit2.Call
import retrofit2.http.*

interface TagService {
    @GET("tag")
    fun tag(@Header("Authorization") token: String): Call<TagResource>

    @POST("tag")
    fun tag(@Header("Authorization") token: String, @Body tag: Tag): Call<Tag>

    @DELETE("tag/{tag_seq}")
    fun tag(@Header("Authorization") token: String, @Path("tag_seq") tagSeq: Int): Call<Boolean>
}