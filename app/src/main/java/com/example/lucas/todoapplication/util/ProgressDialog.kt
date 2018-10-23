package com.example.lucas.todoapplication.util

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import com.example.lucas.todoapplication.R

class ProgressDialog : Dialog {
    val mContext: Context

    constructor(context: Context?) : super(context) {
        mContext = context!!
    }

    constructor(context: Context?, themeResId: Int) : super(context, themeResId) {
        mContext = context!!
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.loading_view)
        setCanceledOnTouchOutside(false)
    }

    override fun onBackPressed() {

    }
}