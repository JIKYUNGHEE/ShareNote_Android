package com.snc.sharenote.ui.main.ui.tradingNotes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.snc.sharenote.databinding.FragmentTradingNotesBinding

class TradingNotesFragment : Fragment() {

    private lateinit var mTradingNotesBinding: FragmentTradingNotesBinding
    private lateinit var tradingNotesViewModel: TradingNotesViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tradingNotesViewModel =
            ViewModelProvider(this).get(TradingNotesViewModel::class.java)
        mTradingNotesBinding = FragmentTradingNotesBinding.inflate(inflater)

        var rvTradingNotes = mTradingNotesBinding.rvTradingNotes
        rvTradingNotes.layoutManager= LinearLayoutManager(context)
        tradingNotesViewModel.tradingNotes.observe(viewLifecycleOwner, Observer {
            rvTradingNotes.adapter = TradingNoteAdapter(it)
        })

        tradingNotesViewModel.text.observe(viewLifecycleOwner, Observer {
            mTradingNotesBinding.textTradingNotes.text = it
        })

        return mTradingNotesBinding.root
    }
}