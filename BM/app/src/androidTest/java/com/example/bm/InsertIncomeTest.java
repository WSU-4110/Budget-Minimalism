package com.example.bm;

import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Looper;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.room.Room;
import androidx.test.core.app.ActivityScenario;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;


import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

@RunWith(AndroidJUnit4.class)
public class InsertIncomeTest {

    //private Context context = ApplicationProvider.getApplicationContext();
    private dataDAO dataDAo;
    private transactionDatabase db;
    private dataViewModel dataViewModel;

    @Rule
    public ActivityScenarioRule<incomeInputScreen> rule  = new ActivityScenarioRule<incomeInputScreen>(incomeInputScreen.class);

    @Before
    public void createDb() {
        Context context = ApplicationProvider.getApplicationContext();
        Looper.prepare();
        db = Room.inMemoryDatabaseBuilder(context, transactionDatabase.class).build();
        dataDAo = db.dataDAO();

    }



    @Test
    public void InsertSingleExpenseTest() {

        rule.getScenario().onActivity(activity -> {
            //dataViewModel dataViewModel2 = new ViewModelProvider(activity).get(dataViewModel.class);
//            dataViewModel =   new ViewModelProvider(activity).get(dataViewModel.class);
//            activity.addIncome_(dataViewModel,"Wayne State", "Paycheck", 110.30);



        });
        transactionEntity t = new transactionEntity("Wayne State", "Paycheck", 110.30, Calendar.getInstance().getTime().toString(), 1);
        dataDAo.insert(t);
        List<transactionEntity> tt = dataDAo.getDescriptionA(110.30);


        Log.e("testing", tt.get(0).getDescription());

        assertEquals("Wayne State", tt.get(0).getDescription());

    }

    @After
    public void closeDb() throws IOException {
        db.close();
    }
}
