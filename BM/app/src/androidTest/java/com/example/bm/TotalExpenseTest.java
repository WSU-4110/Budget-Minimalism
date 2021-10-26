
package com.example.bm;

        import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
        import static org.junit.Assert.assertEquals;
        import static org.junit.Assert.assertThat;

        import android.content.Context;
        import android.os.Looper;
        import android.util.Log;

        import androidx.lifecycle.LiveData;
        import androidx.room.Room;
        import androidx.test.core.app.ApplicationProvider;
        import androidx.test.ext.junit.rules.ActivityScenarioRule;
        import androidx.test.ext.junit.runners.AndroidJUnit4;
        import androidx.test.platform.app.InstrumentationRegistry;



        import org.junit.After;
        import org.junit.Assert;
        import org.junit.Before;
        import org.junit.Rule;
        import org.junit.Test;
        import org.junit.runner.RunWith;

        import java.io.IOException;
        import java.util.Calendar;
        import java.util.List;

@RunWith(AndroidJUnit4.class)
public class TotalExpenseTest {

    //private Context context = ApplicationProvider.getApplicationContext();
    private dataDAO dataDAo;
    private transactionDatabase db;


    @Before
    public void createDb() {
        Context context = ApplicationProvider.getApplicationContext();
        Looper.prepare();
        db = Room.inMemoryDatabaseBuilder(context, transactionDatabase.class).build();
        dataDAo = db.dataDAO();

    }



    @Test
    public void TotalExpenseTest() {


        transactionEntity t = new transactionEntity("Target", "Grocery", 44.30, Calendar.getInstance().getTime().toString(), 0);
        transactionEntity t1 = new transactionEntity("Walmart", "Grocery", 30.30, Calendar.getInstance().getTime().toString(), 0);
        transactionEntity t2 = new transactionEntity("Food pride", "Grocery", 10.30, Calendar.getInstance().getTime().toString(), 0);
        transactionEntity t3 = new transactionEntity("Whole foods", "Grocery", 2.30, Calendar.getInstance().getTime().toString(), 0);
        dataDAo.insert(t);
        dataDAo.insert(t1);
        dataDAo.insert(t2);
        dataDAo.insert(t3);

        double totalExpense = dataDAo.getTotalExpenseDouble();


        Log.e("testing", totalExpense + "");
        Assert.assertEquals(87.20, totalExpense,0.001);


    }

    @After
    public void closeDb() throws IOException {
        db.close();
    }
}
