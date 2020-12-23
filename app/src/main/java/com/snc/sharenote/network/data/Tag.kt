package com.snc.sharenote.network.data

import ch.halarious.core.HalResource

data class Tag(
    val tagSeq: Int,
    val tagName: String,
    val tagUseYn: Boolean,
    val tagUdtDate: String,
    val tagRegDate: String
) : HalResource<Any?>