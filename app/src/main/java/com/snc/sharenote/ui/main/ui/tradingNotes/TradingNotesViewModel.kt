package com.snc.sharenote.ui.main.ui.tradingNotes

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.snc.sharenote.R
import com.snc.sharenote.ui.main.ui.tradingNotes.data.TradingNote

class TradingNotesViewModel(application: Application) : AndroidViewModel(application) {
    private val context = getApplication<Application>().applicationContext

    private val _dayOfTrading = MutableLiveData<String>().apply {
        value = context.getString(R.string.day_of_trading)  //TODO. 달력과 연관시켜서, 반응형으로!
    }
    val dayOfTrading: LiveData<String> = _dayOfTrading

    private val _tradingNotes = MutableLiveData<List<TradingNote>>().apply {
        value = reqGetTradingNotes()
    }
    val tradingNotes:LiveData<List<TradingNote>> = _tradingNotes

    /**
     * 서버에 매매일지 리스트를 요청한다.
     */
    private fun reqGetTradingNotes(): List<TradingNote> {
        var list = arrayListOf<TradingNote>()
        list.add(TradingNote(context.getString(R.string.trading_note_title1),
            arrayListOf(context.getString(R.string.trading_note_test1_tag1), context.getString(R.string.trading_note_test1_tag2))))

        list.add(TradingNote(context.getString(R.string.trading_note_title2),
            arrayListOf(context.getString(R.string.trading_note_test2_tag1), context.getString(R.string.trading_note_test2_tag2), context.getString(R.string.trading_note_test2_tag3),
                context.getString(R.string.trading_note_test2_tag4))))

        list.add(TradingNote(context.getString(R.string.trading_note_title3),
            arrayListOf(context.getString(R.string.trading_note_test3_tag1), context.getString(R.string.trading_note_test3_tag2))))

        list.add(TradingNote(context.getString(R.string.trading_note_title3),
            arrayListOf(context.getString(R.string.trading_note_test3_tag1), context.getString(R.string.trading_note_test3_tag2))))

        list.add(TradingNote(context.getString(R.string.trading_note_title3),
            arrayListOf(context.getString(R.string.trading_note_test3_tag1), context.getString(R.string.trading_note_test3_tag2))))

        list.add(TradingNote(context.getString(R.string.trading_note_title3),
            arrayListOf(context.getString(R.string.trading_note_test3_tag1), context.getString(R.string.trading_note_test3_tag2))))

        list.add(TradingNote(context.getString(R.string.trading_note_title3),
            arrayListOf(context.getString(R.string.trading_note_test3_tag1), context.getString(R.string.trading_note_test3_tag2))))

        list.add(TradingNote(context.getString(R.string.trading_note_title3),
            arrayListOf(context.getString(R.string.trading_note_test3_tag1), context.getString(R.string.trading_note_test3_tag2))))

        list.add(TradingNote(context.getString(R.string.trading_note_title3),
            arrayListOf(context.getString(R.string.trading_note_test3_tag1), context.getString(R.string.trading_note_test3_tag2))))
        return list
    }


}