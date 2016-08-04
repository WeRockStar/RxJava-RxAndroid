package com.werocksta.rxjavaplayground.view.activity;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import com.werocksta.rxjavaplayground.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isChecked;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static junit.framework.Assert.assertEquals;
import static org.hamcrest.Matchers.allOf;

@RunWith(AndroidJUnit4.class)
public class MainFragmentTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void when_go_on_main_page_should_see_button_display() {
        onView(withId(R.id.btnBasic)).check(matches(isDisplayed()));
        onView(withId(R.id.btnBasicOperator)).check(matches(isDisplayed()));
        onView(withId(R.id.btnCombineOperator)).check(matches(isDisplayed()));
        onView(withId(R.id.btnCondition)).check(matches(isDisplayed()));
        onView(withId(R.id.btnFilter)).check(matches(isDisplayed()));
        onView(withId(R.id.btnRetrofit)).check(matches(isDisplayed()));
    }
}
