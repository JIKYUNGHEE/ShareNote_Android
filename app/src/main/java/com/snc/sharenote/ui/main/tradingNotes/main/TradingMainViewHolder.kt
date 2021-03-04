package com.snc.sharenote.ui.main.tradingNotes.main

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.snc.sharenote.R
import com.snc.sharenote.databinding.LayoutTradingNoteBinding

class TradingMainViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.layout_trading_note, parent, false)) {

    private val mBinding: LayoutTradingNoteBinding = LayoutTradingNoteBinding.bind(itemView)

    val title: TextView = mBinding.tvTradingNoteTitle
    var tags1: TextView = mBinding.tvTradingNoteTestTag
    var tags2: TextView = mBinding.tvTradingNoteTestTag2
}
