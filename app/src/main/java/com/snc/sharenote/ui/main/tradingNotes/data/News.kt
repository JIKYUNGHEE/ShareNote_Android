package com.snc.sharenote.ui.main.tradingNotes.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class News(
    val newspaper: String,
    val title: String,
    val summary: String
) : Parcelable