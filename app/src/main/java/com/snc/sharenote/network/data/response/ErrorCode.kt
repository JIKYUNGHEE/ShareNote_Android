package com.snc.sharenote.network.data.response

interface ErrorCode {
}

enum class MemberError : ErrorCode {
    M001, M002, M003, M004, M005, M006, M007
}

enum class TokenError : ErrorCode {
    A001
}