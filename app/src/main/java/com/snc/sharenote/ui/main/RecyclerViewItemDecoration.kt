package com.snc.sharenote.ui.main

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewItemDecoration(divHeight: Int) : RecyclerView.ItemDecoration() {
    private var divHeight = divHeight

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        if (parent.getChildAdapterPosition(view) != parent.adapter?.itemCount?.minus(1))
            outRect.bottom = divHeight
    }
}