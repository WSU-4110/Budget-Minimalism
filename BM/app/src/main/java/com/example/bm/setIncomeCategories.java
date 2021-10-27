package com.example.bm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class setIncomeCategories extends AppCompatActivity {

    private FloatingActionButton back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_income_categories);
        back = (FloatingActionButton) findViewById(R.id.fab);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnToSettingsPage();
            }
        });
    }

    public void returnToSettingsPage() {
        Intent intent = new Intent (this, settingsPage.class);
        startActivity(intent);
    }
}
