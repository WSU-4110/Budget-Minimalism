package com.example.bm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class selectWhichViewPage extends AppCompatActivity {

    // Ian Wixson
    private Button viewRecent;
    private Button viewPercent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_which_view_page);

        viewRecent = (Button) findViewById(R.id.viewRecent); // Main menu sends to expense page
        viewRecent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openViewRecentPage();
            }
        });

        viewPercent = (Button) findViewById(R.id.viewPercent); // Main menu sends to expense page
        viewPercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openViewPercent();
            }
        });

    }

    // Ian Wixson
    public void openViewRecentPage() {
        Intent intent = new Intent(this, view_recent_budget_activity.class);
        startActivity(intent);
    }

    public void openViewPercent() {
        Intent intent = new Intent(this, view_spending_delta.class);
        startActivity(intent);
    }

}
