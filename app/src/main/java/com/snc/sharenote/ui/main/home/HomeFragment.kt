package com.snc.sharenote.ui.main.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.snc.sharenote.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var mHomeBinding: FragmentHomeBinding
    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)
        mHomeBinding = FragmentHomeBinding.inflate(inflater)

        homeViewModel.text.observe(viewLifecycleOwner, Observer { mHomeBinding.textHome.text = it })
        return mHomeBinding.root
    }
}