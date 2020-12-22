package com.snc.sharenote.network.data.response

enum class ErrorCode {
    /**
     * 회원 관련 에러
     */
    M001, M002, M003, M004, M005, M006, M007,

    /**
     * Token 관련 에러
     */
    A001,

    /**
     * SMS 관련 에러
     */
    B001,

    /**
     * 카테고리 관련 에러
     */
    C001, C002,

    /**
     * 종목 관련 에러
     */
    D001,

    /**
     * 파일 관련 에러
     */
    E001,

    /**
     * 매매일지 관련 에러
     */
    F001,

    /**
     * 태그 관련 에러
     */
    G001, G002, G003, G004
}