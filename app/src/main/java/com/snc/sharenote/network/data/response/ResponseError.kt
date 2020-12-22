package com.snc.sharenote.network.data.response

data class ResponseError(
    var message : String = "",
    var status : String = "",
    var errors : String,
    var code : ErrorCode
)