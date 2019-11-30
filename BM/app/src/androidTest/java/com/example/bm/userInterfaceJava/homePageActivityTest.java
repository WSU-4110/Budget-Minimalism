package com.example.bm.userInterfaceJava;


import android.view.View;

import com.example.bm.R;
import com.example.bm.homePageActivity;

import com.example.bm.R;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import org.junit.rules.TestRule;

import androidx.test.rule.ActivityTestRule;

import static org.junit.Assert.*;

public class homePageActivityTest extends homePageActivity {

    @Rule
    public ActivityTestRule<homePageActivity> mActivityTestRule = new androidx.test.rule.ActivityTestRule<homePageActivity>(homePageActivity.class);
    private homePageActivity mActivity = null;

    @Before
    public void setUp() throws Exception {
        mActivity = mActivityTestRule.getActivity();

    }

    @Test
    public void testLaunch() {

        View view = mActivity.findViewById(R.id.button2);
        assertNotNull(view);


    }



    @After
    public void tearDown() throws Exception {
        mActivity = null;


    }
}