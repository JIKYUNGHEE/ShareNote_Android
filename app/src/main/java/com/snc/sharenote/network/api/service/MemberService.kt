package com.snc.sharenote.network.api.service

import com.snc.sharenote.network.data.response.ResponseDefault
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface MemberService {
    @GET("/api/rest/member/duplicate_id/{user_id}")
    @Headers("Content-Type: application/json")
    fun checkDuplicateId(@Path("user_id") id : String) : Call<ResponseDefault>
}