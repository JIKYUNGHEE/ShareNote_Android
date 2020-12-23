package com.snc.sharenote.network.data

import ch.halarious.core.HalLink
import ch.halarious.core.HalResource

data class Member(
    val mbrId: String? = "",
    val mbrPwd: String? = "",
    val mbrName: String? = null,
    val mbrEmail: String? = null,
    val mbrUuid: String? = null,
    val mbrType: String? = "",
    val mbrPhoneNum: String? = "",
    val mbrCategory: String? = null,
    val mbrGrade: String? = null,
    val mbrState: String? = null,
    val mbrUseYn: String? = null,
    val mbrUdtDate: String? = null,
    val mbrRegDate: String? = null,
    @HalLink val self: String? = "",
    @HalLink val token: String? = "",
    @HalLink val list: String? = "",
    @HalLink val read: String? = "",
    @HalLink val update: String? = "",
    @HalLink val delete: String? = ""
) : HalResource<Any?>