package com.snc.sharenote.ui.main.tradingNotes.data

data class Stock(
    val name: String,           //주식명
    val type: StockType,           //분류
    val tradingTime: String,    //거래시간
    val buyingPrice: String,   //매수가
    val sellingPrice: String,   //매도가
    val value: String      //평가금액
) {
    fun initStockTitleValue(): ArrayList<StockTitle> {
        val stockTitleValue = ArrayList<StockTitle>()
        for (stockTitle in StockTitle.values()) {
            var addStockTitle: StockTitle? = null
            when (stockTitle.ordinal) {
                0 -> addStockTitle = StockTitle.createStockTitle(StockTitle.NAME, name)
                1 -> addStockTitle = StockTitle.createStockTitle(StockTitle.TYPE, type.nameKor)
                2 -> addStockTitle = StockTitle.createStockTitle(StockTitle.TRADING_TIME, tradingTime)
                3 -> addStockTitle = StockTitle.createStockTitle(StockTitle.BUYING_PRICE, buyingPrice)
                4 -> addStockTitle = StockTitle.createStockTitle(StockTitle.SELLING_PRICE, sellingPrice)
                5 -> addStockTitle = StockTitle.createStockTitle(StockTitle.VALUE, value)
            }

            if (addStockTitle != null) {
                stockTitleValue.add(addStockTitle)
            }
        }

        return stockTitleValue
    }
}