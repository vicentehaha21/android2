package com.example.lucas.todoapplication.viewpager

import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.support.v4.view.ViewPager
import com.example.lucas.todoapplication.R

class ScreenSlidePagerActivity : FragmentActivity() {

    lateinit var mPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen_slide)
        mPager = findViewById(R.id.pager)
        mPager.adapter = ScreenSlidePagerAdapter(supportFragmentManager, 5)
    }

    override fun onBackPressed() {
        if (mPager.currentItem == 0) super.onBackPressed() else mPager.currentItem--
    }
}