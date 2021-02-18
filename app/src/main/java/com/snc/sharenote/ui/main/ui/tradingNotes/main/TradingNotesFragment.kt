package com.snc.sharenote.ui.main.ui.tradingNotes.main

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.snc.sharenote.databinding.FragmentTradingNotesBinding
import com.snc.sharenote.ui.main.RecyclerViewItemDecoration

class TradingNotesFragment : Fragment() {

    private lateinit var mTradingNotesBinding: FragmentTradingNotesBinding
    private lateinit var tradingNotesViewModel: TradingNotesViewModel
    private var drawerToggle = true

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tradingNotesViewModel =
            ViewModelProvider(this).get(TradingNotesViewModel::class.java)
        mTradingNotesBinding = FragmentTradingNotesBinding.inflate(inflater)


        var targetView = mTradingNotesBinding.content
        var drawerButton = mTradingNotesBinding.drawer
        drawerButton.setOnClickListener {
            if (drawerToggle) {
                var objectAnimator: ObjectAnimator =
                    ObjectAnimator.ofFloat(targetView, View.TRANSLATION_Y, 800f)
                objectAnimator.duration = 500
                objectAnimator.start()
            } else {
                var objectAnimator: ObjectAnimator =
                    ObjectAnimator.ofFloat(targetView, View.TRANSLATION_Y, 0f)
                objectAnimator.duration = 500
                objectAnimator.start()
            }
            drawerToggle = !drawerToggle
        }

        var rvTradingNotes = mTradingNotesBinding.rvTradingNotes
        rvTradingNotes.layoutManager = LinearLayoutManager(context)
        rvTradingNotes.addItemDecoration(RecyclerViewItemDecoration(30))

        tradingNotesViewModel.tradingNotes.observe(viewLifecycleOwner, Observer {
            rvTradingNotes.adapter =
                TradingNoteAdapter(
                    it
                )
        })

        tradingNotesViewModel.dayOfTrading.observe(viewLifecycleOwner, Observer {
            mTradingNotesBinding.dayTradingNotes.text = it
        })

        return mTradingNotesBinding.root
    }
}