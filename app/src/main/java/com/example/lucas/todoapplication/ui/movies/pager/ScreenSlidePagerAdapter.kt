package com.example.lucas.todoapplication.ui.movies.pager

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.lucas.todoapplication.R
import com.example.lucas.todoapplication.domain.TmdbData

class ScreenSlidePagerAdapter(val context: Context, val topRateds: ArrayList<TmdbData>) : PagerAdapter() {

    override fun isViewFromObject(view: View, any: Any): Boolean {
        return view == any
    }

    override fun getCount(): Int = topRateds.size

    override fun getItemPosition(`object`: Any): Int {
        return topRateds.indexOf(`object`)
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = LayoutInflater.from(context).inflate(R.layout.fragment_screen_slide_page, container, false)

        view.findViewById<TextView>(R.id.pager_text).text = topRateds[position].title

        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, view: Any) {
        container.removeView(view as View);
    }
}