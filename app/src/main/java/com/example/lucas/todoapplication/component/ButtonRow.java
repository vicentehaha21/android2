package com.example.lucas.todoapplication.component;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.lucas.todoapplication.R;

public class ButtonRow extends RelativeLayout {

    public ButtonRow(Context context) {
        super(context);
        init(null);
    }

    public ButtonRow(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public ButtonRow(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        inflate(getContext(), R.layout.buttons_rows, this);
        TypedArray stylesAttrs = getContext().getTheme().obtainStyledAttributes(attrs, R.styleable.ButtonRow, 0, 0);
        setAttrs(stylesAttrs);
    }

    private void setAttrs(TypedArray stylesAttrs) {
        String first = stylesAttrs.getString(R.styleable.ButtonRow_first);
        String sec = stylesAttrs.getString(R.styleable.ButtonRow_second);
        String third = stylesAttrs.getString(R.styleable.ButtonRow_third);
        String fourth = stylesAttrs.getString(R.styleable.ButtonRow_fourth);

        ((Button) findViewById(R.id.firstButton)).setText(first);
        ((Button) findViewById(R.id.secondButton)).setText(sec);
        ((Button) findViewById(R.id.thirdButton)).setText(third);
        ((Button) findViewById(R.id.fourthButton)).setText(fourth);
    }
}
