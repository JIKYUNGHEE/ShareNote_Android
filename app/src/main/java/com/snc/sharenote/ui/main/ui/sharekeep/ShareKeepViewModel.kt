package com.snc.sharenote.ui.main.ui.sharekeep

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShareKeepViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is ShareKeep Fragment"
    }
    val text: LiveData<String> = _text
}