package com.snc.sharenote.network.data

import com.snc.sharenote.network.data.ErrorCode

data class ResponseError(
    var message: String = "",
    var status: String = "",
    var errors: String,
    var code: ErrorCode
)