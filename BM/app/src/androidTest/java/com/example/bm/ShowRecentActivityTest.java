package com.example.bm;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertEquals;

import android.content.Context;
import android.os.Looper;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.Observer;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertThat;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;

import androidx.lifecycle.LiveData;

@RunWith(AndroidJUnit4.class)
public class ShowRecentActivityTest {


    //private Context context = ApplicationProvider.getApplicationContext();
    private dataDAO dataDAo;
    private transactionDatabase db;
    private dataViewModel dataViewModel;

    @Rule
    public ActivityScenarioRule<viewRecentBudgetActivity> rule  = new ActivityScenarioRule<>(viewRecentBudgetActivity.class);

    @Before
    public void createDb() {
        Context context = ApplicationProvider.getApplicationContext();
        Looper.prepare();
        db = Room.inMemoryDatabaseBuilder(context, transactionDatabase.class).build();
        dataDAo = db.dataDAO();

    }



    @Test
    public void InsertSingleExpenseTest() throws InterruptedException {
        transactionEntity t = new transactionEntity("Target", "Grocery", 44.30, Calendar.getInstance().getTime().toString(), 0);
        transactionEntity t1 = new transactionEntity("Walmart", "Grocery", 30.30, Calendar.getInstance().getTime().toString(), 0);
        transactionEntity t2 = new transactionEntity("Food pride", "Grocery", 10.30, Calendar.getInstance().getTime().toString(), 0);
        transactionEntity t3 = new transactionEntity("Whole foods", "Grocery", 2.30, Calendar.getInstance().getTime().toString(), 0);
        dataDAo.insert(t);
        dataDAo.insert(t1);
        dataDAo.insert(t2);
        dataDAo.insert(t3);


        List<transactionEntity> res = dataDAo.getAllTransactions();



        rule.getScenario().onActivity(activity -> {
            View recView = activity.findViewById(R.id.recview);
            assertThat(recView, instanceOf(RecyclerView.class));
            RecyclerView rView = (RecyclerView) recView;
            transactionsAdapter adapter = (transactionsAdapter) rView.getAdapter();
            List<transactionEntity> resFinal = null;
            adapter.setWords(res);
            //assertThat(adapter, instanceOf(transactionsAdapter.class));
            //assertThat(adapter.getItemCount(), greaterThan(3));
            Assert.assertEquals(adapter.getItemCount(), 4);


        });

    }


    @After
    public void closeDb() throws IOException {
        db.close();
    }
}

