package com.snc.sharenote.ui.main.tradingNotes.write

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import com.snc.sharenote.R
import com.snc.sharenote.databinding.FragmentTradingNoteWriteBinding
import com.snc.sharenote.ui.main.tradingNotes.CustomBottomSheetDialog

class TradingNoteWriteFragment : Fragment() {
    private lateinit var mBinding: FragmentTradingNoteWriteBinding
    private lateinit var mNoteWriteViewModel: TradingNoteWriteViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mNoteWriteViewModel = ViewModelProvider(this).get(TradingNoteWriteViewModel::class.java)
        mBinding = FragmentTradingNoteWriteBinding.inflate(inflater)

        //거래주식
        val stocksViewPager: ViewPager = mBinding.layoutStocks.viewpager
        mNoteWriteViewModel.stockList.observe(viewLifecycleOwner, Observer {
            stocksViewPager.adapter = StockViewPager(it)
        })
        mBinding.layoutStocks.tvTitle.text = getString(R.string.post_trading_note_stocks_title)
        mBinding.layoutStocks.tabIndicator.setupWithViewPager(stocksViewPager, true)
        mBinding.layoutStocks.btnPostTradingNoteStocksAdd.setOnClickListener { showPostStocksDialog() }

        //관련뉴스
        val newsViewPager: ViewPager = mBinding.layoutNews.viewpager
        mNoteWriteViewModel.newsList.observe(viewLifecycleOwner, Observer {
            newsViewPager.adapter = NewsViewPager(it)
        })
        mBinding.layoutNews.tvTitle.text = getString(R.string.post_trading_note_news_title)
        mBinding.layoutNews.tabIndicator.setupWithViewPager(newsViewPager, true)

        return mBinding.root
    }

    private fun showPostStocksDialog() {
        val dialog =
            CustomBottomSheetDialog()
        activity?.supportFragmentManager?.let { dialog.show(it, "CustomBottomSheetDialog") }
    }
}