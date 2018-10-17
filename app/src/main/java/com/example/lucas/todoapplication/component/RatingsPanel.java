package com.example.lucas.todoapplication.component;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.example.lucas.todoapplication.R;

public class RatingsPanel extends RelativeLayout {

    public RatingsPanel(Context context) {
        super(context);
        init(null);
    }

    public RatingsPanel(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public RatingsPanel(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        inflate(getContext(), R.layout.movie_panel, this);
    }
}
