package com.snc.sharenote.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.snc.sharenote.R

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        navController = findNavController(R.id.main_nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home,
                R.id.navigation_analysis,
                R.id.navigation_tradingMain,
                R.id.navigation_notifications
            )
        )

        var actionBar:ActionBar? = supportActionBar
        actionBar?.title = getString(R.string.title_tradingNotes)
        var appBarLayout = findViewById<AppBarLayout>(R.id.app_bar)
        var toolbar = appBarLayout.findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        var writeButton = toolbar.findViewById<Button>(R.id.btn_write)
        writeButton.setOnClickListener { startActivity(Intent(this, TradingNoteActivity::class.java)) }

        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.actionbar_menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.create_note -> {
                startActivity(Intent(this, TradingNoteActivity::class.java))
                return true
            }
        }
        return false
    }
}