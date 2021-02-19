package com.snc.sharenote

import com.nhn.android.idp.common.logger.Logger
import com.snc.sharenote.network.api.service.MemberService
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Mock private lateinit var memberService: MemberService

    @Before
    fun setUp(){
    }

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun addition_isCorrect2() {
        print(1111)

        assertEquals(4, 2 + 2)
    }

    @Test
    fun callDuplicateId_and_ResponseIsCorrect() {
//        val testDuplicateId = "zvkbeng12345"
//        memberService.checkDuplicateId(testDuplicateId).enqueue(object :
//            Callback<ResponseDuplicateMember> {
//            override fun onFailure(call: Call<ResponseDuplicateMember>, t: Throwable) {
//                Log.d("TAG", "onFailure")
//            }
//
//            override fun onResponse(call: Call<ResponseDuplicateMember>, response: Response<ResponseDuplicateMember>) {
//                Log.d("Tag", "onResponse")
//                if(response.code() == 200) {
//                    var member : ResponseDuplicateMember? = response.body()
//                    assertEquals(member?.msg, "사용중인 아이디 입니다.")
//                } else {
//                    Log.d("TAG", "onResponse error code")
//                }
//            }
//        })
    }
}
