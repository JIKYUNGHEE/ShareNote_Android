package com.snc.sharenote.ui.main.ui.tradingNotes

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.snc.sharenote.ui.main.ui.tradingNotes.data.TradingNote

class TradingNoteAdapter : RecyclerView.Adapter<TradingNoteViewHolder>() {
    private lateinit var list: List<TradingNote>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TradingNoteViewHolder {
        return TradingNoteViewHolder(parent)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: TradingNoteViewHolder, position: Int) {
        var note = list[position]
        holder.title = note.title
        holder.tags1 = note.tags[0]
        holder.tags2 = note.tags[1]
    }
}
