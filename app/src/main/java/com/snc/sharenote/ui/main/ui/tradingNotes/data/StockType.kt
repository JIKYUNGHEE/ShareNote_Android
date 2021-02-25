package com.snc.sharenote.ui.main.ui.tradingNotes.data

enum class StockType(nameKor: String) {
    BUY("매수"),
    SELL("매도"),
    DIVIDE("배당"),
    ETC("기타");

    val nameKor = nameKor
}