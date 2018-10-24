package com.example.lucas.todoapplication;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.ViewAssertion;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    private MainActivity mainActivity;

    @Before
    public void before() {
        this.mainActivity = mActivityTestRule.getActivity();
    }

    @Test
    public void useAppContext() {
//        // Context of the app under test.
//        Context appContext = InstrumentationRegistry.getTargetContext();
//
//        assertEquals("com.example.lucas.todoapplication", appContext.getPackageName());

        Espresso.onView(ViewMatchers.withId(R.id.movieSearch)).perform(ViewActions.typeText("Homem-aranha"));
        Espresso.onView(ViewMatchers.withId(R.id.searchButton)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.moviesList)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }
}
