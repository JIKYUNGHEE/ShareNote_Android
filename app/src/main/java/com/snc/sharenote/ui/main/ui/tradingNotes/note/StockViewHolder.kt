package com.snc.sharenote.ui.main.ui.tradingNotes.note

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.snc.sharenote.R
import kotlinx.android.synthetic.main.layout_trading_note_stock_row.view.*

class StockViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
    //TODO. ViewBinding 으로 바꾸기
    LayoutInflater.from(parent.context).inflate(R.layout.layout_trading_note_stock_row, parent, false)) {

    val title: TextView = itemView.tv_stock_title
    val content: TextView = itemView.tv_stock_content
}
