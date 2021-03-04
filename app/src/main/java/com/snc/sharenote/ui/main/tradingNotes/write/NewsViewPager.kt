package com.snc.sharenote.ui.main.tradingNotes.write

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.snc.sharenote.databinding.LayoutTradingNoteNewsBinding
import com.snc.sharenote.ui.main.tradingNotes.data.News

class NewsViewPager(private val newsList: List<News>) : PagerAdapter() {
    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getCount(): Int {
        return newsList.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val binding : LayoutTradingNoteNewsBinding = LayoutTradingNoteNewsBinding.inflate(LayoutInflater.from(container.context))

        val news = newsList[position]
        binding.tvNewspaper.text = news.newspaper
        binding.tvTitle.text = news.title
        binding.tvSummary.text = news.summary
        container.addView(binding.root)

        return binding.root
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}
