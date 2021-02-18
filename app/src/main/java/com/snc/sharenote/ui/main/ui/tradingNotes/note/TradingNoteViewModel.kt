package com.snc.sharenote.ui.main.ui.tradingNotes.note

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TradingNoteViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is TradingNote Fragment"
    }
    val text: LiveData<String> = _text
}