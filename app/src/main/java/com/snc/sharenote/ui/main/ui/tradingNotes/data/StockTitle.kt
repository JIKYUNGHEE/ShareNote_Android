package com.snc.sharenote.ui.main.ui.tradingNotes.data

enum class StockTitle(title: String, htmlFormat: String) {

    NAME("주식명", "<b><u>%s</u></b>"),
    TYPE("분류",  ""),
    TRADING_TIME("거래시간", ""),
    CALLING_PRICE("매수가",  ""),
    SELLING_PRICE("매도가",  ""),
    VALUE("평가금액", "");

    val title = title
    var content = ""
    val htmlFormat = htmlFormat


    companion object {
        fun createStockTitle(title: StockTitle, content: String): StockTitle? {
            if (!content.isNullOrEmpty()) {
                var stockTitle = title
                stockTitle.content = content
                return stockTitle
            }
            return null
        }
    }
}