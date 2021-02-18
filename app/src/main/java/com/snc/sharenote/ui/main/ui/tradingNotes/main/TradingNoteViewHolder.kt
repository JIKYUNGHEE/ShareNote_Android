package com.snc.sharenote.ui.main.ui.tradingNotes.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.snc.sharenote.R
import com.snc.sharenote.databinding.LayoutTradingNoteBinding
import kotlinx.android.synthetic.main.layout_trading_note.view.*

class TradingNoteViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_trading_note, parent, false)) {
    val title: TextView = itemView.tv_trading_note_title
    var tags1: TextView = itemView.tv_trading_note_test_tag
    var tags2: TextView = itemView.tv_trading_note_test_tag2
}
