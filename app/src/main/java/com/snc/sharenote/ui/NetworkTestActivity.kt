package com.snc.sharenote.ui

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.snc.sharenote.databinding.ActivityNetworkTestBinding
import com.snc.sharenote.network.RetrofitClient
import com.snc.sharenote.network.api.service.MemberService
import com.snc.sharenote.network.data.response.ResponseDefault
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class NetworkTestActivity : AppCompatActivity() {
    private val TAG = this::class.java.simpleName

    private lateinit var retrofit: Retrofit
    private lateinit var memberService: MemberService
    private lateinit var binding : ActivityNetworkTestBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "$TAG onCreate()")
        binding = ActivityNetworkTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /* 서버 연결 */
        initRetrofit()

        binding.btnCheckDuplicate.setOnClickListener {
            val keyword = binding.etCheckId.text.toString()
            if (keyword != "") {
                checkDuplicate(keyword)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
    }

    private fun initRetrofit() {
        retrofit = RetrofitClient.getInstance()
        memberService = retrofit.create(MemberService::class.java)
    }

    private fun checkDuplicate(keyword: String) {
        memberService.checkDuplicateId(keyword).enqueue(object : Callback<ResponseDefault> {
            override fun onFailure(call: Call<ResponseDefault>, t: Throwable) {
                Log.d(TAG, "실패 : {$t}")
            }

            override fun onResponse(
                call: Call<ResponseDefault>,
                response: Response<ResponseDefault>
            ) {
                Log.d(TAG, "성공^^")
                if (response.code() == 200) {  // 성공상태
                    Log.d(TAG, "state : ${response.body()!!.state}, msg : ${response.body()!!.msg}")
                } else {    // 에러상태
                    Log.d(TAG, "에러 : ${response.code()}")
                }
            }
        })
    }
}