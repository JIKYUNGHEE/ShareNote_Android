package com.snc.sharenote.ui.main.ui.tradingNotes.note

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.snc.sharenote.ui.main.ui.tradingNotes.data.Stock

class TradingNoteViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is TradingNote Fragment"
    }
    val text: LiveData<String> = _text

    private val _stockList = MutableLiveData<List<Stock>>().apply {
        value = reqGetStockList()
    }
    val stockList: LiveData<List<Stock>> = _stockList

    private fun reqGetStockList(): List<Stock>? {
        val lists = arrayListOf<Stock>()
        lists.add(Stock("삼성전자"))
        lists.add(Stock("기아자동차"))
        lists.add(Stock("모바일리더"))

        return lists
    }
}