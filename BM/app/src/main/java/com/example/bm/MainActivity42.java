package com.example.bm;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class HomePageActivity extends AppCompatActivity {
    // Object name declarations
    private Button button2;         //Main menu "Expense" button object
    private Button incomeButton;    //Main menu "Income" button object
    private Button viewButton;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        //Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        // Mitchell:
        // This code connects the xml "Expense" button and the java object "button2"
        // We really need to change the strings.xml file so its not so confusing but...
        // then it creates a click listener, so that when we click on it
        // the button calls the openActivity_expense_inputscreen()
        button2 = (Button) findViewById(R.id.button2); // Main menu sends to expense page
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity_expense_inputscreen();
            }
        });

        // Mitchell:
        // This code connects the xml "Income" button and the java object "incomeButton"
        // then it creates a click listener, so that when we click on it
        // the button calls the openActivity_expense_inputscreen()
        incomeButton = (Button) findViewById(R.id.incomeButton);
        incomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity_income_inputscreen();
            }
        });

        // This function sends you to the settings page
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Snackbar.make(view, "WRITE CODE TO SEND U TO SETTINGS", Snackbar.LENGTH_LONG)
                //       .setAction("Action", null).show();
                sendYoutoSettingsPage();
            }
        });

        viewButton = (Button) findViewById(R.id.button3);
        viewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendYouToViewRecent();
            }
        });
    }
    // Mitchell wrote this function
    public void openActivity_expense_inputscreen() {
        Intent intent = new Intent(this, expense_inputscreen.class);
        startActivity(intent);
    }

    // Mitchell
    public void openActivity_income_inputscreen() {
        Intent intent = new Intent(this, income_inputscreen.class);
        startActivity(intent);
    }

    // Mitchell
    public void sendYoutoSettingsPage() {
        Intent intent = new Intent (this, settingsPage.class);
        startActivity(intent);
    }

    // This function sends you to the view_recent_budget_activity
    public void sendYouToViewRecent() {
        Intent intent = new Intent (this, selectWhichViewPage.class);
        startActivity(intent);
    }
/**
    // Android Studio default code
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    // Android Studio default code
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
**/
}
