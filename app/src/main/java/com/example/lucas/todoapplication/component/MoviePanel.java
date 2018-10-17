package com.example.lucas.todoapplication.component;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.lucas.todoapplication.R;

public class MoviePanel extends RelativeLayout {

    public MoviePanel(Context context) {
        super(context);
        init(null);
    }

    public MoviePanel(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public MoviePanel(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        inflate(getContext(), R.layout.movie_panel, this);
    }
}
