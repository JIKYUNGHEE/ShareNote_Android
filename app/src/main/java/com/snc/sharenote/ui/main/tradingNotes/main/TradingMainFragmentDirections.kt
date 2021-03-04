package com.snc.sharenote.ui.main.tradingNotes.main

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.snc.sharenote.R

public class TradingMainFragmentDirections private constructor() {
  public companion object {
    public fun actionTradingMainToTradingNote(): NavDirections =
        ActionOnlyNavDirections(R.id.action_tradingMain_to_tradingNote)
  }
}
