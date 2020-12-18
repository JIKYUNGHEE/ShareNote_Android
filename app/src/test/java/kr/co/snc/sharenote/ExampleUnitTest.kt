package kr.co.snc.sharenote

import kr.co.snc.sharenote.network.api.service.MemberService
import kr.co.snc.sharenote.network.data.response.ResponseDuplicateMember
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    private lateinit var memberService: MemberService

    @Before
    fun setUpTest(){
        memberService = MemberService.create()
    }

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun callDuplicateId_and_ResponseIsCorrect() {
        val testDuplicateId = "zvkbeng12345"
        memberService.checkDuplicateId(testDuplicateId).
        enqueue(object :
            Callback<ResponseDuplicateMember> {
            override fun onFailure(call: Call<ResponseDuplicateMember>, t: Throwable) {

            }

            override fun onResponse(call: Call<ResponseDuplicateMember>, response: Response<ResponseDuplicateMember>) {

            }

        })
    }
}
