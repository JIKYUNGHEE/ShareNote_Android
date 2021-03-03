package com.snc.sharenote.ui.main.ui.tradingNotes.note

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.snc.sharenote.databinding.LayoutCustomBottomSheetBinding
import java.lang.ClassCastException

class CustomBottomSheetDialog : BottomSheetDialogFragment() {
    private lateinit var mBinding: LayoutCustomBottomSheetBinding
    private lateinit var mListener: BottomSheetListener

    interface BottomSheetListener {
        fun onButtonClicked(): Any
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = LayoutCustomBottomSheetBinding.inflate(inflater)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
//            mListener = context as BottomSheetListener
        } catch (e: ClassCastException) {
            throw ClassCastException("$context must implement BottomSheetListener");
        }
    }
}