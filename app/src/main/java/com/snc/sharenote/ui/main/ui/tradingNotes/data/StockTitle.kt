package com.snc.sharenote.ui.main.ui.tradingNotes.data

enum class StockTitle(title: String, htmlFormat: String) {

    NAME("주식명", "<b><u>%s</u></b>  %s"),
    TYPE("분류",  "%s"),
    TRADING_TIME("거래시간", "%s"),
    BUYING_PRICE("매수가",  "%s | %s"),
    SELLING_PRICE("매도가",  "%s | %s"),
    VALUE("평가금액", "%s");

    val title = title
    var content = listOf<String>()
    val htmlFormat = htmlFormat

    companion object {
        const val contentSeparator = ";";

        fun createStockTitle(title: StockTitle, content: String): StockTitle? {
            if (!content.isNullOrEmpty()) {
                var stockTitle = title
                stockTitle.content = content.split(contentSeparator)
                return stockTitle
            }
            return null
        }
    }
}