package com.snc.sharenote.ui.main.tradingNotes.write

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.snc.sharenote.ui.main.tradingNotes.data.*

class TradingNoteWriteViewModel() : ViewModel() {
    private val _tradingNote = MutableLiveData<TradingNote>().apply {
        value = createTradingNote()
    }

    val tradingNote: LiveData<TradingNote> = _tradingNote
    val mTradingNote: TradingNote? = tradingNote.value

    private fun createTradingNote(): TradingNote? {
        //TODO. 빈값 제어
        val tradingNote = TradingNote(
            title = title?.value.orEmpty(),
            tags = tagList?.value.orEmpty(),
            date = date?.value.orEmpty(),
            stockList = stockList?.value,
            newsList = newsList?.value,
            memo = "메모입니다."
        )
        return tradingNote
    }

    private val _title = MutableLiveData<String>().apply {
        value = reqTitle()
    }
    val title: LiveData<String>? = _title

    private val _tagList = MutableLiveData<List<String>>().apply {
        value = reqTagList()
    }

    val tagList: LiveData<List<String>>? = _tagList

    private val _date = MutableLiveData<String>().apply {
        value = reqDate()
    }

    val date: LiveData<String>? = _date

    private val _stockList = MutableLiveData<List<Stock>>().apply {
        value = reqGetStockList()
    }
    val stockList: LiveData<List<Stock>>? = _stockList

    private val _newsList = MutableLiveData<List<News>>().apply {
        value = reqGetNewsList()
    }
    val newsList: LiveData<List<News>>? = _newsList

    private fun reqTitle(): String? {
        return "매매일지 제목입니다."
    }

    private fun reqTagList(): List<String>? {
        val list = arrayListOf<String>()
        list.add("태그1")
        list.add("태그2")
        list.add("태그3")
        list.add("태그4")
        return list
    }

    private fun reqDate(): String? {
        return "2021.03.14 AM8:47"
    }

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

    private fun reqGetNewsList(): List<News>? {
        val lists = arrayListOf<News>()
        lists.add(
            News(
                "연합뉴스",
                "주식 엄청난 수익률 달성해 출연 료 안받아도 된다 한 연예인111111",
                "소비자에게 비용전가 미 38개주 구글 반독점 소송가세소비 자에게 비용전가 미 38개주 구글 반독점 소송가세소비자에 게 비용 전가미 38개주 구글 반독점 소송가세 소송가세소  소송가세 소…"
            )
        )

        lists.add(
            News(
                "네이버뉴스",
                "주식 엄청난 수익률 달성해 출연 료 안받아도 된다 한 연예인버2222222",
                "소비자에게 비용전가 미 38개주 구글 반독점 소송가세소비 자에게 비용전가 미 38개주 구글 반독점 소송가세소비자에 게 비용 전가미 38개주 구글 반독점 소송가세 소송가세소  소송가세 소…"
            )
        )

        lists.add(
            News(
                "연합뉴스",
                "주식 엄청난 수익률 달성해 출연 료 안받아도 된다 한 연예인33333",
                "소비자에게 비용전가 미 38개주 구글 반독점 소송가세소비 자에게 비용전가 미 38개주 구글 반독점 소송가세소비자에 게 비용 전가미 38개주 구글 반독점 소송가세 소송가세소  소송가세 소…"
            )
        )
        return lists
    }
}