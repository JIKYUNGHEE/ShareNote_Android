package com.snc.sharenote.ui.main.ui.tradingNotes

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.snc.sharenote.databinding.LayoutTradingNoteBinding

class TradingNoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private lateinit var layoutTradingNoteBinding: LayoutTradingNoteBinding

    lateinit var title: String
    lateinit var tags1: String
    lateinit var tags2: String

}
