package com.example.bm;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertEquals;

import android.content.Context;
import android.os.Looper;
import android.util.Log;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

import static org.junit.Assert.assertThat;

import android.view.View;
import android.widget.TextView;



@RunWith(AndroidJUnit4.class)
public class InputExpenseTest {

    //private Context context = ApplicationProvider.getApplicationContext();
    private dataDAO dataDAo;
    private transactionDatabase db;

    @Rule
    public ActivityScenarioRule<expenseInputScreen> rule  = new ActivityScenarioRule<>(expenseInputScreen.class);

    @Before
    public void createDb() {
        Context context = ApplicationProvider.getApplicationContext();
        Looper.prepare();
        db = Room.inMemoryDatabaseBuilder(context, transactionDatabase.class).build();
        dataDAo = db.dataDAO();

    }



    @Test
    public void InputExpenseTextTest() {
        rule.getScenario().onActivity(activity -> {
            View viewById = activity.findViewById(R.id.textView12);
            assertThat(viewById,notNullValue());
            assertThat(viewById, instanceOf(TextView.class));
            TextView textView = (TextView) viewById;
            activity.setText(textView);
            assertThat(textView.getText().toString(),is("Input Expense"));





        });

    }

    @After
    public void closeDb() throws IOException {
        db.close();
    }
}

