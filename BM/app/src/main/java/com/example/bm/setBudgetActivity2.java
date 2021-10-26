package com.example.bm;

import static com.example.bm.homePageActivity.monthlyBudget;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class setBudgetActivity2 extends AppCompatActivity {

    private Button backButton;
    private Button submitBudgetButton;
    private TextView budgetField;
    private String budgetFieldValue;
    private double budgetValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_budget2);

        // Button variables
        backButton = (Button)findViewById(R.id.button6);
        submitBudgetButton = (Button)findViewById(R.id.button5);
        budgetField = (TextView) findViewById(R.id.editTextNumberDecimal2);



        // For submitting the budget
        submitBudgetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                budgetFieldValue = budgetField.getText().toString();
                budgetValue = Double.parseDouble(budgetFieldValue);

                monthlyBudget.setBudgetValue(budgetValue);
                System.out.println("Monthly budget: " + monthlyBudget.getBudgetValue());
                Toast.makeText(setBudgetActivity2.this, "Your monthly budget has been set!", Toast.LENGTH_SHORT).show();

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