package com.example.lucas.todoapplication.ui.loading

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import com.example.lucas.todoapplication.R

class LoadingView : RelativeLayout {
    private lateinit var mContext: Context

    constructor(context: Context): super(context) {
        init(context)
    }

    constructor(context: Context, attributes: AttributeSet): super(context, attributes) {
        init(context)
    }

    fun init(context: Context) {
        mContext = context
        View.inflate(mContext, R.layout.loading_view, this)
    }

    fun hide() {
        visibility = View.GONE
    }

    fun show() {
        visibility = View.VISIBLE
    }
}