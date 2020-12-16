package kr.co.snc.sharenote.network.api.service

import kr.co.snc.sharenote.network.data.response.ResponseDuplicateMember
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface MemberService {
    companion object {
        private const val BASE_URL = "http://52.79.246.196:8083";
    }

    fun create() : MemberService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MemberService::class.java)
    }


    @GET("/api/rest/member/duplicate_id")
    fun checkDuplicateId(
        @Query("") id : String
    ) : Call<ResponseDuplicateMember>
}