package com.example.bm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class income_inputscreen extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private FloatingActionButton back; //this object is for the back button

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income_inputscreen);


        // This code connects the xml back button and the java object
        // then it creates a click listener, so that when we click on it
        // the button calls the returnToMainMenuPlease()
        back = (FloatingActionButton) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnToMainMenuPlease();
            }
        });

        // Mitchell
        // This code enables the categories spinner on the expense input page
        Spinner spinner = findViewById(R.id.spinner); // create new spinner object
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.incomeCategoriesArray, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

    }

    // This function simply sends the user back to the main menu activity
    public void returnToMainMenuPlease() {
        Intent intent = new Intent (this, HomePageActivity.class);
        startActivity(intent);
    }

    // This code is so that the item tapped from the dropdown menu is actually selected
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
