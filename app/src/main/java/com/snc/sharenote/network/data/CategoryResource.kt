package com.snc.sharenote.network.data

import ch.halarious.core.HalEmbedded
import ch.halarious.core.HalLink
import ch.halarious.core.HalResource

data class CategoryResource(
    @HalEmbedded val category: Array<Category>,
    @HalLink val self: String
) : HalResource<Any?>