package com.example.bm;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Calendar;


//this class takes input from user for recording income
public class incomeInputScreen extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private dataViewModel dataViewModel;
    private FloatingActionButton back;
    private EditText DescriptionBox;
    private Button submitButton;
    private EditText amountEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income_inputscreen);


        // Mitchell:
        // This code connects the xml back button and the java object
        // then it creates a click listener, so that when we click on it
        // the button calls the returnToMainMenuPlease()
        back = (FloatingActionButton) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            //returns to main menu

            @Override
            public void onClick(View v) {
                returnToMainMenuPlease();
            }
        });

        // Mitchell
        // This code enables the categories spinner on the expense input page
        Spinner spinner = findViewById(R.id.spinner); // create new spinner object
        ArrayAdapter<CharSequence> adapter =
                ArrayAdapter.createFromResource(
                    this, R.array.incomeCategoriesArray, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        // Mitchell
        // Getting user input from the amount and description fields
        DescriptionBox = findViewById(R.id.incomeDescript);
        submitButton = (Button) findViewById(R.id.incomeSubmit);
        dataViewModel = new ViewModelProvider(this).get(dataViewModel.class);
        amountEditText = findViewById(R.id.editText6); // we really must rename the xml objects soon

        submitButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String description = DescriptionBox.getText().toString();
                String amount = amountEditText.getText().toString();
                // this string is an amalgamation of the other string objects
                String sendIt ="+ "+amount+" "+description+ " on "+date;

                // if both fields not filled, you cannot continue.
                if(!description.equals("") && !amount.equals("")) {
                    addIncome(description, "Paycheck", Double.parseDouble(amount));
                    returnToMainMenuPlease();
                } else {
                    toastMessage("Please fill in all fields");
                }
            }
        });
    } // end onCreate


    // Mitchell Fenner
    // setting up a date object
    java.util.Date date = new java.util.Date();

    private void addIncome(String description, String type, double amount ){
        transactionEntity newTransaction2 = new transactionEntity(description, type, amount, Calendar.getInstance().getTime().toString(), 1);
        dataViewModel.insert(newTransaction2);
        Log.e("room", "income is added");
    }

    // This function simply sends the user back to the main menu activity
    public void returnToMainMenuPlease() {
        Intent intent = new Intent (this, homePageActivity.class);
        startActivity(intent);
    }

    // Toast message function for data entry input
    private void toastMessage(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

    // Used to want a toast message on category selection but its just annoying now
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //String text = parent.getItemAtPosition(position).toString();
        //toastMessage(text);
    }

    // Code created by default in android studio
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }


}
