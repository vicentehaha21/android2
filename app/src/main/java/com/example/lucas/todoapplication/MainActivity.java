package com.example.lucas.todoapplication;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.lucas.todoapplication.ui.movies.toprated.TopRatedFragment;
import com.example.lucas.todoapplication.ui.movies.pager.ScreenSlideFragment;

public class MainActivity extends AppCompatActivity {
    private ViewPager mPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().add(R.id.topRatedFragment, new TopRatedFragment()).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.topRatedPagerFragment, new ScreenSlideFragment()).commit();
    }

}
