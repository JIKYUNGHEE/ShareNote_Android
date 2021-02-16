package com.snc.sharenote.ui.main.ui.tradingNotes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TradingNotesViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is tradingNotes Fragment"
    }
    val text: LiveData<String> = _text
}