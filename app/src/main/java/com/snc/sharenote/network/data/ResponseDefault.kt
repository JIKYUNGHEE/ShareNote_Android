package com.snc.sharenote.network.data

import ch.halarious.core.HalLink
import ch.halarious.core.HalResource
import java.math.BigInteger


data class ResponseDefault(var state: Boolean, var msg: String, @HalLink val self: String? = null) :
    HalResource<Any?>