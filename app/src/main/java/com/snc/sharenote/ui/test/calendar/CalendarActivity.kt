package com.snc.sharenote.ui.test.calendar

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.snc.sharenote.databinding.ActivityCalendarBinding

class CalendarActivity : AppCompatActivity() {
    private lateinit var mCalendarBinding: ActivityCalendarBinding

    private var drawerToggle = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mCalendarBinding = ActivityCalendarBinding.inflate(layoutInflater)
        setContentView(mCalendarBinding.root)

        var targetView = mCalendarBinding.content
        var drawerButton = mCalendarBinding.drawer
        drawerButton.setOnClickListener {
            if (drawerToggle) {
                var objectAnimator: ObjectAnimator =
                    ObjectAnimator.ofFloat(targetView, View.TRANSLATION_Y, -1200f)
                objectAnimator.duration = 500
                objectAnimator.start()
            } else {
                var objectAnimator: ObjectAnimator =
                    ObjectAnimator.ofFloat(targetView, View.TRANSLATION_Y, 0f)
                objectAnimator.duration = 500
                objectAnimator.start()
            }
            drawerToggle = !drawerToggle
        }
    }
}