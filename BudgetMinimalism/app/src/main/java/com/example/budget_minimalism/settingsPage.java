package com.example.budget_minimalism;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class settingsPage extends AppCompatActivity {

    private Button SetIncomeCategories;
    private Button setExpenseCategories;

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
    }

    // This function ebables the "Set Income Categories" button
    public void goSetIncomeCategories() {
        Intent intent = new Intent (this, set_income_categories.class);
        startActivity(intent);
    }

    // This function enables the "Set expense categories" button
    public void goSetExpenseCategories() {
        Intent intent = new Intent (this, set_expense_categories.class);
        startActivity(intent);
    }
}