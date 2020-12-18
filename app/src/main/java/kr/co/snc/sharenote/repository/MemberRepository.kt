package kr.co.snc.sharenote.repository

import kr.co.snc.sharenote.network.api.service.MemberService

class MemberRepository {
    private val mMemberService: MemberService = MemberService.create()

    fun checkDuplicateId(id : String) {
//        return mMemberService.checkDuplicateId(id).execute()
    }
}