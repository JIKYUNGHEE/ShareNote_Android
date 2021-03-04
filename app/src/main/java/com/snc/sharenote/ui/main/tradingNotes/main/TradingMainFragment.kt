package com.snc.sharenote.ui.main.tradingNotes.main

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.snc.sharenote.databinding.FragmentTradingMainBinding
import com.snc.sharenote.ui.main.RecyclerViewItemDecoration

class TradingMainFragment : Fragment() {

    private lateinit var mBinding: FragmentTradingMainBinding
    private lateinit var mMainViewModel: TradingMainViewModel
    private var drawerToggle = true

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mMainViewModel =
            ViewModelProvider(this).get(TradingMainViewModel::class.java)
        mBinding = FragmentTradingMainBinding.inflate(inflater)


        var targetView = mBinding.content
        var drawerButton = mBinding.drawer
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

        var rvTradingNotes = mBinding.rvTradingNotes
        rvTradingNotes.layoutManager = LinearLayoutManager(context)
        rvTradingNotes.addItemDecoration(
            RecyclerViewItemDecoration(
                30
            )
        )

        mMainViewModel.tradingNotes.observe(viewLifecycleOwner, Observer {
            rvTradingNotes.adapter =
                TradingMainAdapter(
                    it
                )
        })

        mMainViewModel.dayOfTrading.observe(viewLifecycleOwner, Observer {
            mBinding.dayTradingNotes.text = it
        })

        return mBinding.root
    }
}