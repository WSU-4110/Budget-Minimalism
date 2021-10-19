package com.example.bm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class selectWhichViewPage extends AppCompatActivity {
    
    private Button viewRecent;
    private Button viewPercent;
    private FloatingActionButton back;



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
            public void onClick(View v) { openViewPercent(); }
        });

        back = (FloatingActionButton) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { returnToMainMenuPlease(); }
        });


    }

    public void openViewRecentPage() {
        Intent intent = new Intent(this, viewRecentBudgetActivity.class);
        startActivity(intent);
    }

    public void openViewPercent() {
        Intent intent = new Intent(this, viewSpendingDelta.class);
        startActivity(intent);
    }


    public void returnToMainMenuPlease() {
        Intent intent = new Intent (this, homePageActivity.class);
        startActivity(intent);
    }




}
