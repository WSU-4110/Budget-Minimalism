package com.example.budget_minimalism;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class set_expense_categories extends AppCompatActivity {

    private FloatingActionButton back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_expense_categories);
        back = (FloatingActionButton) findViewById(R.id.fab);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnToSettingsPage();
            }
        });
    }


    // Mitchell - return to settings
    public void returnToSettingsPage() {
        Intent intent = new Intent (this, settingsPage.class);
        startActivity(intent);
    }
}
