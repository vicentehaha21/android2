package com.example.lucas.todoapplication.viewpager

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.example.lucas.todoapplication.viewpager.ScreenSliderFragment

class ScreenSlidePagerAdapter(fm: FragmentManager, val numPages: Int) : FragmentStatePagerAdapter(fm) {

    override fun getItem(position: Int): Fragment = ScreenSliderFragment()

    override fun getCount(): Int = numPages
}