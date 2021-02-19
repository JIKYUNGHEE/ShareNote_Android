package com.snc.sharenote.ui.main.ui.tradingNotes.note

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.snc.sharenote.R
import kotlinx.android.synthetic.main.layout_post_trading_note_stock.view.*

class StockViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.layout_post_trading_note_stock, parent, false)) {

    val name: TextView = itemView.tv_name_title
}
