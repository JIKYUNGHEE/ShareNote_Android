package com.snc.sharenote.network.api.service

import com.snc.sharenote.network.data.CategoryResource
import com.snc.sharenote.network.data.ResponseDefault
import com.snc.sharenote.network.data.Member
import retrofit2.Call
import retrofit2.http.*

interface MemberService {
    @GET("member/duplicate_id/{mbrId}")
    fun checkDuplicateId(@Path("mbrId") id: String): Call<ResponseDefault>

    @GET("member/auth")
    fun loginNormal(
        @Query("mbrId") id: String,
        @Query("mbrPwd") pwd: String
    ): Call<Member>

    @GET("member/auth/sns")
    fun loginSns(
        @Query("mbrUuid") uuid: String,
        @Query("mbrType") mbrType: String
    ): Call<Member>

    @POST("member/join")
    fun join(@Body member: Member): Call<Member>


    @GET("member/{mbrId}")
    fun member(
        @Header("Authorization") token: String,
        @Path("mbrId") id: String
    ): Call<Member>

    @PUT("member")
    fun member(
        @Header("Authorization") token: String,
        @Body member: Member
    ): Call<Member>

    @DELETE("member")
    fun member(@Header("Authorization") token: String): Call<Boolean>

    @GET("member/auth/phone_num/{phone_num}")
    fun certPhone(@Path("phone_num") phoneNum: String): Call<ResponseDefault>

    @GET("member/find_id/{phone_num}")
    fun findId(@Path("phone_num") phoneNum: String): Call<Member>

    @GET("member/category")
    fun category(@Header("Authorization") token: String): Call<CategoryResource>

    @PUT("member/category")
    fun category(
        @Header("Authorization") token: String,
        @Body member: Member
    ): Call<Member>
}