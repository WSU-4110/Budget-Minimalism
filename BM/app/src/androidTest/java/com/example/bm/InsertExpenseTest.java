package com.example.bm;

import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import android.content.Context;
import android.os.Looper;
import android.util.Log;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;



import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

@RunWith(AndroidJUnit4.class)
public class InsertExpenseTest {

    //private Context context = ApplicationProvider.getApplicationContext();
    private dataDAO dataDAo;
    private transactionDatabase db;

//    @Rule
//    public ActivityScenarioRule<expenseInputScreen> e =
//            new ActivityScenarioRule(expenseInputScreen.class);

    @Before
    public void createDb() {
        Context context = ApplicationProvider.getApplicationContext();
        Looper.prepare();
        db = Room.inMemoryDatabaseBuilder(context, transactionDatabase.class).build();
        dataDAo = db.dataDAO();
        //e = new expenseInputScreen();
    }



    @Test
    public void InsertSingleExpenseTest() {
        //e.getScenario();

            //expenseInputScreen e = new expenseInputScreen();
            //e.getScenario().insertExpense("Walmart", "Grocery", 11.30);
            transactionEntity t = new transactionEntity("Macy","Shopping",30.30, Calendar.getInstance().getTime().toString(), 0);
            dataDAo.insert(t);
            List<transactionEntity> desc = dataDAo.getDescription(30.30, 0);
            Log.e("testing", desc.get(0).getDescription());
            //assertThat("Walmart", desc);
            assertEquals("Macy", desc.get(0).getDescription());

            // Here you can call methods which have Handler



        //assertEquals("com.example.bm", appContext.getPackageName());
    }

    @After
    public void closeDb() throws IOException {
        db.close();
    }
}
