package com.snc.sharenote.ui

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.snc.sharenote.databinding.ActivityNetworkTestBinding
import com.snc.sharenote.network.RetrofitClient
import com.snc.sharenote.network.api.service.CategoryService
import com.snc.sharenote.network.api.service.MemberService
import com.snc.sharenote.network.api.service.TagService
import com.snc.sharenote.network.data.CategoryResource
import com.snc.sharenote.network.data.Member
import com.snc.sharenote.network.data.ResponseDefault
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import java.nio.charset.Charset

class NetworkTestActivity : AppCompatActivity() {
    private val TAG = this::class.java.simpleName

    private lateinit var retrofit: Retrofit
    private lateinit var memberService: MemberService
    private lateinit var categoryService: CategoryService
    private lateinit var tagService: TagService

    private lateinit var binding: ActivityNetworkTestBinding

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

        binding.btnLoginNormal.setOnClickListener {
            val id = "tester1"
            val pwd = "tester1"
            loginNormal(id, pwd)
        }
        binding.btnLoginSns.setOnClickListener {
            val uuid = "12345"
            val mbrType = "kakao"
            loginSns(uuid, mbrType)
        }
        binding.btnJoin.setOnClickListener {
            val member: Member =
                Member("tester1", "tester1", "이", "", null, "normal", "010-1234-5678")
            join(member)
        }
        binding.btnFindMember.setOnClickListener {
            val id: String = "tester1"
            val token: String =
                "eyJhbGciOiJIUzUxMiJ9.eyJleHAiOjE2MTExMjk5ODksImlhdCI6MTYwODUzNzk4OSwianRpIjoidGVzdGVyMSJ9.bzWn1_oNxR2B55abFt3jU-CZJvPKaJbLOYFbInnnaO5pMURzbedDeMh06ssprbnFGCL6g6CtlOYfEbLjl-b6ww"
            member(id, token)
        }
        binding.btnEditMember.setOnClickListener {
            val member: Member = Member("", "", "이테스", "", null, null, "01012345678")
            val token: String =
                "eyJhbGciOiJIUzUxMiJ9.eyJleHAiOjE2MTExMjk5ODksImlhdCI6MTYwODUzNzk4OSwianRpIjoidGVzdGVyMSJ9.bzWn1_oNxR2B55abFt3jU-CZJvPKaJbLOYFbInnnaO5pMURzbedDeMh06ssprbnFGCL6g6CtlOYfEbLjl-b6ww"
            member(member, token)
        }
        binding.btnDeleteMember.setOnClickListener {
            val token: String =
                "eyJhbGciOiJIUzUxMiJ9.eyJleHAiOjE2MTExMjk5ODksImlhdCI6MTYwODUzNzk4OSwianRpIjoidGVzdGVyMSJ9.bzWn1_oNxR2B55abFt3jU-CZJvPKaJbLOYFbInnnaO5pMURzbedDeMh06ssprbnFGCL6g6CtlOYfEbLjl-b6ww"
            member(token)
        }
        binding.btnCertPhone.setOnClickListener {
            val phoneNum = "01051750553"
            certPhone(phoneNum)
        }
        binding.btnFindId.setOnClickListener {
            val phoneNum = "01090371961"
            findId(phoneNum)
        }
        binding.btnCategoryList.setOnClickListener {
            val token: String =
                "eyJhbGciOiJIUzUxMiJ9.eyJleHAiOjE2MTExMjk5ODksImlhdCI6MTYwODUzNzk4OSwianRpIjoidGVzdGVyMSJ9.bzWn1_oNxR2B55abFt3jU-CZJvPKaJbLOYFbInnnaO5pMURzbedDeMh06ssprbnFGCL6g6CtlOYfEbLjl-b6ww"
            getCategoryList(token)
        }
        binding.btnEditCategory.setOnClickListener {
            val token: String =
                "eyJhbGciOiJIUzUxMiJ9.eyJleHAiOjE2MTExMjk5ODksImlhdCI6MTYwODUzNzk4OSwianRpIjoidGVzdGVyMSJ9.bzWn1_oNxR2B55abFt3jU-CZJvPKaJbLOYFbInnnaO5pMURzbedDeMh06ssprbnFGCL6g6CtlOYfEbLjl-b6ww"
            val member: Member = Member(null, null, null, null, null, null, null, "1")
            editCategoryList(token, member)
        }
    }

    private fun editCategoryList(token: String, member: Member) {
        memberService.category(token, member).enqueue(object : Callback<Member> {
            override fun onFailure(call: Call<Member>, t: Throwable) {
                Log.d(TAG, "실패 : {$t}")
            }

            override fun onResponse(
                call: Call<Member>,
                response: Response<Member>
            ) {
                Log.d(TAG, "카테고리 수정 응답 성공^^")
                if (response.code() == 200) {  // 성공상태
                    Log.d(TAG, "state : ${response.body()!!.mbrCategory}")
                } else {    // 에러상태
                    Log.e(TAG, "에러 : ${response.code()}")
                    Log.e(
                        TAG,
                        "내용: ${response.errorBody()!!.source()
                            .readString(Charset.forName("UTF-8"))}"
                    )
                }
            }
        })
    }

    private fun getCategoryList(token: String) {
        memberService.category("Bearer $token").enqueue(object : Callback<CategoryResource> {
            override fun onFailure(call: Call<CategoryResource>, t: Throwable) {
                Log.d(TAG, "실패 : {$t}")
            }

            override fun onResponse(
                call: Call<CategoryResource>,
                response: Response<CategoryResource>
            ) {
                Log.d(TAG, "카테고리 리스트 응답 성공^^")
                if (response.code() == 200) {  // 성공상태
                    Log.d(TAG, "state : ${response.body()!!.category.get(0).ctgName}")
                } else {    // 에러상태
                    Log.e(TAG, "에러 : ${response.code()}")
                    Log.e(
                        TAG,
                        "내용: ${response.errorBody()!!.source()
                            .readString(Charset.forName("UTF-8"))}"
                    )
                }
            }
        })
    }

    private fun findId(phoneNum: String) {
        memberService.findId(phoneNum).enqueue(object : Callback<Member> {
            override fun onFailure(call: Call<Member>, t: Throwable) {
                Log.d(TAG, "실패 : {$t}")
            }

            override fun onResponse(call: Call<Member>, response: Response<Member>) {
                Log.d(TAG, "핸드폰으로 id 찾기 응답 성공^^")
                if (response.code() == 200) {  // 성공상태
                    Log.d(
                        TAG,
                        "pwd : ${response.body()!!.mbrPwd}, mbrRegDate : ${response.body()!!.mbrRegDate}"
                    )
                } else {    // 에러상태
                    Log.e(TAG, "에러 : ${response.code()}")
                    Log.e(
                        TAG,
                        "내용: ${response.errorBody()!!.source()
                            .readString(Charset.forName("UTF-8"))}"
                    )
                }
            }
        })
    }

    private fun certPhone(phoneNum: String) {
        memberService.certPhone(phoneNum).enqueue(object : Callback<ResponseDefault> {
            override fun onFailure(call: Call<ResponseDefault>, t: Throwable) {
                Log.d(TAG, "실패 : {$t}")
            }

            override fun onResponse(
                call: Call<ResponseDefault>,
                response: Response<ResponseDefault>
            ) {
                Log.d(TAG, "핸드폰 인증 응답 성공^^")
                if (response.code() == 200) {  // 성공상태
                    Log.d(TAG, "state : ${response.body()!!.state}, msg : ${response.body()!!.msg}")
                } else {    // 에러상태
                    Log.e(TAG, "에러 : ${response.code()}")
                    Log.e(
                        TAG,
                        "내용: ${response.errorBody()!!.source()
                            .readString(Charset.forName("UTF-8"))}"
                    )
                }
            }
        })
    }

    private fun member(token: String) {
        memberService.member("Bearer $token").enqueue(object : Callback<Boolean> {
            override fun onFailure(call: Call<Boolean>, t: Throwable) {
                Log.d(TAG, "실패 : {$t}")
            }

            override fun onResponse(
                call: Call<Boolean>,
                response: Response<Boolean>
            ) {
                Log.d(TAG, "회원 삭제 응답 성공^^")
                if (response.code() == 200) {  // 성공상태
                    Log.d(TAG, "성공코드: ${response.code()}")
                } else {    // 에러상태
                    Log.e(TAG, "에러 : ${response.code()}")
                }
            }
        })
    }

    private fun member(member: Member, token: String) {
        memberService.member("Bearer $token", member).enqueue(object : Callback<Member> {
            override fun onFailure(call: Call<Member>, t: Throwable) {
                Log.d(TAG, "실패 : {$t}")
            }

            override fun onResponse(
                call: Call<Member>,
                response: Response<Member>
            ) {
                Log.d(TAG, "회원 정보 수정 응답 성공^^")
                if (response.code() == 200) {  // 성공상태
                    Log.d(
                        TAG,
                        "pwd : ${response.body()!!.mbrPwd}, mbrRegDate : ${response.body()!!.mbrRegDate}"
                    )
                } else {    // 에러상태
                    Log.e(TAG, "에러 : ${response.code()}")
                    Log.e(
                        TAG,
                        "내용: ${response.errorBody()!!.source()
                            .readString(Charset.forName("UTF-8"))}"
                    )
                }
            }
        })
    }

    private fun member(id: String, token: String) {
        memberService.member("Bearer $token", id).enqueue(object : Callback<Member> {
            override fun onFailure(call: Call<Member>, t: Throwable) {
                Log.d(TAG, "실패 : {$t}")
            }

            override fun onResponse(
                call: Call<Member>,
                response: Response<Member>
            ) {
                Log.d(TAG, "회원조회 응답 성공^^")
                if (response.code() == 200) {  // 성공상태
                    Log.d(
                        TAG,
                        "pwd : ${response.body()!!.mbrPwd}, mbrRegDate : ${response.body()!!.mbrRegDate}"
                    )
                } else {    // 에러상태
                    Log.e(TAG, "에러 : ${response.code()}")
                    Log.e(TAG, "내용: ${response.errorBody()!!.source()}")
                }
            }
        })
    }

    private fun join(member: Member) {
        memberService.join(member).enqueue(object : Callback<Member> {
            override fun onFailure(call: Call<Member>, t: Throwable) {
                Log.d(TAG, "실패 : {$t}")
            }

            override fun onResponse(
                call: Call<Member>,
                response: Response<Member>
            ) {
                Log.d(TAG, "회원가입 응답 성공^^")
                if (response.code() == 200) {  // 성공상태
                    Log.d(
                        TAG,
                        "pwd : ${response.body()!!.mbrPwd}, mbrRegDate : ${response.body()!!.mbrRegDate}"
                    )
                } else {    // 에러상태
                    Log.d(TAG, "에러 : ${response.code()}, 내용: ${response.errorBody()!!.source()}")
                }
            }
        })
    }


    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
    }

    private fun initRetrofit() {
        retrofit = RetrofitClient.getInstance()
        memberService = retrofit.create(MemberService::class.java)
        categoryService = retrofit.create(CategoryService::class.java)
        tagService = retrofit.create(TagService::class.java)
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
                    Log.d(
                        TAG,
                        "state : ${response.body()!!.state}, msg : ${response.body()!!.msg}, href: ${response.body()!!.self}"
                    )
                } else {    // 에러상태
                    Log.d(TAG, "에러 : ${response.code()}")
                }
            }
        })
    }

    private fun loginNormal(id: String, pwd: String) {
        memberService.loginNormal(id, pwd).enqueue(object : Callback<Member> {

            override fun onFailure(call: Call<Member>, t: Throwable) {
                Log.d(TAG, "실패 : {$t}")
            }

            override fun onResponse(
                call: Call<Member>,
                response: Response<Member>
            ) {
                Log.d(TAG, "normal 성공^^")
                if (response.code() == 200) {  // 성공상태
                    Log.d(
                        TAG,
                        "pwd : ${response.body()!!.mbrPwd}, mbrRegDate : ${response.body()!!.mbrRegDate}"
                    )
                } else {    // 에러상태
                    Log.d(TAG, "에러 : ${response.code()}")
                }
            }
        })
    }

    private fun loginSns(uuid: String, mbrType: String) {
        memberService.loginSns(uuid, mbrType).enqueue(object : Callback<Member> {
            override fun onFailure(call: Call<Member>, t: Throwable) {
                Log.d(TAG, "실패 : {$t}")
            }

            override fun onResponse(
                call: Call<Member>,
                response: Response<Member>
            ) {
                Log.d(TAG, "sns 로그인 성공^^")
                if (response.code() == 200) {  // 성공상태
                    Log.d(
                        TAG,
                        "pwd : ${response.body()!!.mbrPwd}, mbrRegDate : ${response.body()!!.mbrRegDate}"
                    )
                } else {    // 에러상태
                    Log.d(TAG, "에러 : ${response.code()}")
                }
            }
        })
    }
}
