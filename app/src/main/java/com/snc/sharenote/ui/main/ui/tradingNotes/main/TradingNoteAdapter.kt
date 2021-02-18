package com.snc.sharenote.ui.main.ui.tradingNotes.main

import android.text.TextUtils
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.snc.sharenote.ui.main.ui.tradingNotes.data.TradingNote

class TradingNoteAdapter(var tradingNotes: List<TradingNote>) :
    RecyclerView.Adapter<TradingNoteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TradingNoteViewHolder {
        return TradingNoteViewHolder(
            parent
        )
    }

    override fun getItemCount(): Int {
        return tradingNotes.size
    }

    override fun onBindViewHolder(holder: TradingNoteViewHolder, position: Int) {
        var note = tradingNotes[position]

        holder.title.text = if (!TextUtils.isEmpty(note.title)) note.title else ""
        holder.tags1.text = if (!TextUtils.isEmpty(note.tags[0])) note.tags [0] else ""
        holder.tags2.text = if (!TextUtils.isEmpty(note.tags[1])) note.tags [1] else ""
    }
}
