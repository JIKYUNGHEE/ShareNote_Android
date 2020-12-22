package com.snc.sharenote.network.data.response

import ch.halarious.core.HalResource
import java.math.BigInteger


data class ResponseDefault(var state:Boolean, var msg:String) : HalResource<Any?>