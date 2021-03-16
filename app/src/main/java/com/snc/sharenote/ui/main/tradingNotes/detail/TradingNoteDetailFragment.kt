package com.snc.sharenote.ui.main.tradingNotes.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.snc.sharenote.databinding.FragmentTradingNoteDetailBinding
import com.snc.sharenote.ui.main.tradingNotes.write.TradingNoteWriteViewModel


private const val ARG_TRADING_NOTE = "param1"
private const val ARG_PARAM2 = "param2"

class TradingNoteDetailFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var mBinding:FragmentTradingNoteDetailBinding
    private val mNoteWriteViewModel: TradingNoteWriteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            param1 = it.getString(ARG_TRADING_NOTE)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mBinding = FragmentTradingNoteDetailBinding.inflate(inflater)
        mNoteWriteViewModel.mTradingNote?.let {
            mBinding.tv.text = it.title + it.tags + it.stockList.toString() + it.newsList.toString() + it.memo
        }
        return mBinding.root
    }

    companion object {
        fun newInstance(param1: String, param2: String) =
            TradingNoteDetailFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_TRADING_NOTE, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}