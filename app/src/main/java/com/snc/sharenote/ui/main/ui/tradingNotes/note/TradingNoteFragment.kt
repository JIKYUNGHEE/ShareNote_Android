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
    private lateinit var mBinding: FragmentTradingNoteBinding
    private lateinit var mNoteViewModel: TradingNoteViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mNoteViewModel = ViewModelProvider(this).get(TradingNoteViewModel::class.java)
        mBinding = FragmentTradingNoteBinding.inflate(inflater)
        val stocksViewPager: ViewPager = mBinding.layoutStocks.stocksViewPager   //TODO. ViewPager2
        mNoteViewModel.stockList.observe(viewLifecycleOwner, Observer {
            stocksViewPager.adapter = StockViewPager(it)
        })

        mNoteViewModel.text.observe(viewLifecycleOwner, Observer { mBinding.textTradingNote.text = it })

        return mBinding.root
    }
}