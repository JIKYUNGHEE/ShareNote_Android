package com.snc.sharenote.network.data

import ch.halarious.core.HalResource

data class Category(
    val ctgSeq: Int,
    val ctgName: String,
    val ctgPopularity: Int,
    val ctgUseYn: String?,
    val ctgUdtDate: String?,
    val ctgRegDate: String?
) : HalResource<Any?>