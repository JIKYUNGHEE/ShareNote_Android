package com.snc.sharenote.ui.main.ui.tradingNotes.note

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import com.snc.sharenote.databinding.FragmentTradingNoteBinding

class TradingNoteFragment : Fragment() {
    private lateinit var tradingNoteViewModel: TradingNoteViewModel
    private lateinit var mTradingNoteBinding: FragmentTradingNoteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tradingNoteViewModel = ViewModelProvider(this).get(TradingNoteViewModel::class.java)
        mTradingNoteBinding = FragmentTradingNoteBinding.inflate(inflater)
        val stocksViewPager: ViewPager = mTradingNoteBinding.layoutStocks.stocksViewPager   //TODO. ViewPager2
        tradingNoteViewModel.stockList.observe(viewLifecycleOwner, Observer {
            stocksViewPager.adapter = StockViewPager(it)
        })

        tradingNoteViewModel.text.observe(viewLifecycleOwner, Observer { mTradingNoteBinding.textTradingNote.text = it })

        return mTradingNoteBinding.root
    }
}