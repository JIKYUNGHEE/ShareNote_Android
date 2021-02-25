package com.snc.sharenote.ui.main.ui.tradingNotes.note

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.snc.sharenote.ui.main.ui.tradingNotes.data.Stock
import com.snc.sharenote.ui.main.ui.tradingNotes.data.StockTitle
import com.snc.sharenote.ui.main.ui.tradingNotes.data.StockType

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
        lists.add(
            Stock(
                "삼성전자" + StockTitle.contentSeparator + "011200",
                StockType.BUY,
                "2021년 2월 22일 오후 7:43",
                "12,000원" + StockTitle.contentSeparator + "1주",
                "",
                "12,000원"
            )
        )
        lists.add(
            Stock(
                "기아자동차" + StockTitle.contentSeparator + "011202",
                StockType.SELL,
                "2021년 2월 23일 오후 3:43",
                "",
                "12,000원" + StockTitle.contentSeparator + "1주",
                "12,000원"
            )
        )
        lists.add(
            Stock(
                "모바일리더" + StockTitle.contentSeparator + "011203",
                StockType.SELL,
                "2021년 2월 23일 오후 3:43",
                "",
                "12,000원" + StockTitle.contentSeparator + "1주",
                "12,000원"
            )
        )

        return lists
    }
}