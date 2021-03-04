package com.snc.sharenote.ui.main.analysis

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.snc.sharenote.databinding.FragmentAnalysisBinding

class AnalysisFragment : Fragment() {

    private lateinit var mAnalysisBinding: FragmentAnalysisBinding
    private lateinit var analysisViewModel: AnalysisViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        analysisViewModel = ViewModelProvider(this).get(AnalysisViewModel::class.java)
        mAnalysisBinding = FragmentAnalysisBinding.inflate(inflater)
        analysisViewModel.text.observe(
            viewLifecycleOwner,
            Observer { mAnalysisBinding.textAnalysis.text = it })
        return mAnalysisBinding.root
    }
}