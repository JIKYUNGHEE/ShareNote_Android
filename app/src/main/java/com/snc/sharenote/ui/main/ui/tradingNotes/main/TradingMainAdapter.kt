package com.snc.sharenote.ui.main.ui.tradingNotes.main

import android.text.TextUtils
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.snc.sharenote.ui.main.ui.tradingNotes.data.TradingNote

class TradingMainAdapter(var tradingNotes: List<TradingNote>) :
    RecyclerView.Adapter<TradingMainViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TradingMainViewHolder {
        return TradingMainViewHolder(parent)
    }

    override fun getItemCount(): Int {
        return tradingNotes.size
    }

    override fun onBindViewHolder(holderMain: TradingMainViewHolder, position: Int) {
        var note = tradingNotes[position]

        holderMain.title.text = if (!TextUtils.isEmpty(note.title)) note.title else ""
        holderMain.tags1.text = if (!TextUtils.isEmpty(note.tags[0])) note.tags[0] else ""
        holderMain.tags2.text = if (!TextUtils.isEmpty(note.tags[1])) note.tags[1] else ""
    }
}
