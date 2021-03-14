package com.snc.sharenote.ui.main.tradingNotes.data

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TradingNote(
    var title: String,
    var tags: List<String>,
    var date: String? = null,
    var stockList: List<Stock>? = null,
    var newsList: List<News>? = null,
    var memo: String? = null
) : Parcelable