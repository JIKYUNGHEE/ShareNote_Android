package com.snc.sharenote.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.snc.sharenote.R
import com.snc.sharenote.ui.main.tradingNotes.main.TradingMainFragmentDirections

class TradingNoteActivity : AppCompatActivity() {
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trading_note)

        navController = findNavController(R.id.trading_nav_host_fragment)

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_write_tradingNote,
                R.id.navigation_detail_tradingNote
            )
        )

        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.actionbar_menu_trading, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.save_note -> {
                var directions: NavDirections =  TradingMainFragmentDirections.actionTradingMainToTradingNote()
                navController.navigate(directions)
                return true
            }
        }
        return false
    }
}