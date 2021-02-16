package com.snc.sharenote.ui.main.ui.shareKeep

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.snc.sharenote.databinding.FragmentSharekeepBinding

class ShareKeepFragment : Fragment() {
    private lateinit var mShareKeepBinding: FragmentSharekeepBinding
    private lateinit var shareKeepViewModel: ShareKeepViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        shareKeepViewModel =
            ViewModelProvider(this).get(ShareKeepViewModel::class.java)
        mShareKeepBinding = FragmentSharekeepBinding.inflate(inflater)

        shareKeepViewModel.text.observe(
            viewLifecycleOwner, Observer { mShareKeepBinding.textShareKeep.text = it })
        return mShareKeepBinding.root
    }
}