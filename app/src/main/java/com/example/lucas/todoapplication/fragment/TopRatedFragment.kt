package com.example.lucas.todoapplication.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lucas.todoapplication.R

class TopRatedFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)
        inflater.inflate(R.layout.top_rateds_fragment, container, false)
        init()
        return view
    }

    private fun init() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}