package com.example.bm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class settingsPage extends AppCompatActivity {

    // Mitchell: this may be redundant to declare objects like this, need to check
    private Button SetIncomeCategories;
    private Button setExpenseCategories;
    private FloatingActionButton back; //this object is for the back button

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_page);

        //Mitchell
        SetIncomeCategories = (Button) findViewById(R.id.SetIncomeCategories);
        SetIncomeCategories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goSetIncomeCategories();
            }
        });

        // Mitchell
        setExpenseCategories = (Button) findViewById(R.id.setExpenseCategories);
        setExpenseCategories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goSetExpenseCategories();
            }
        });

        back = (FloatingActionButton) findViewById(R.id.fab2);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnToMainMenuPlease();
            }
        });
    }

    // This function ebables the "Set Income Categories" button
    public void goSetIncomeCategories() {
        Intent intent = new Intent (this, setIncomeCategories.class);
        startActivity(intent);
    }

    // This function enables the "Set expense categories" button
    public void goSetExpenseCategories() {
        Intent intent = new Intent (this, com.example.bm.setExpenseCategories.class);
        startActivity(intent);
    }

    // Mitchell: redundant function. I wish I could call the function from another class
    // but those classes are not static, and I'm not instantiating them so no dice.
    public void returnToMainMenuPlease() {
        Intent intent = new Intent (this, homePageActivity.class);
        startActivity(intent);
    }
}