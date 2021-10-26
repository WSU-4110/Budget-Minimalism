package com.example.bm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class setBudgetActivity extends AppCompatActivity {

    private Button backButton;
    private Button submitBudgetButton;
    private TextView budgetField;
    private String budgetFieldValue;
    private double budgetValue;
    public static Budget monthlyBudget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set_budget_layout);

        // Button variables
        backButton = (Button)findViewById(R.id.button6);
        submitBudgetButton = (Button)findViewById(R.id.button5);
        budgetField = (TextView) findViewById(R.id.editTextNumberDecimal2);

        monthlyBudget = new Budget(0.00);

        // For submitting the budget
        submitBudgetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                budgetFieldValue = budgetField.getText().toString();
                budgetValue = Double.parseDouble(budgetFieldValue);

                monthlyBudget.setBudgetValue(budgetValue);

                Toast.makeText(setBudgetActivity.this, "Your monthly budget has been set!", Toast.LENGTH_SHORT).show();

            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnToMain();
            }
        });


    }

    // Function to return to the main screen
    public void returnToMain() {
        Intent intent = new Intent (this, homePageActivity.class);
        startActivity(intent);
    }



}


