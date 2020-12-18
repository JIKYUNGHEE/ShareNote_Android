package kr.co.snc.sharenote.network.api.service

import kr.co.snc.sharenote.network.data.response.ResponseDuplicateMember
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface MemberService {
    companion object {
        fun create(): MemberService {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MemberService::class.java)
        }

        private const val BASE_URL = "http://52.79.246.196:8083";
    }

    @GET("/api/rest/member/duplicate_id/{user_id}")
    @Headers("Content-Type: application/json")
    fun checkDuplicateId(@Path("user_id") id : String) : Call<ResponseDuplicateMember>
}