package com.example.bm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class developerInfoPage extends AppCompatActivity {

    private FloatingActionButton back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer_info_page);

        back = (FloatingActionButton) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { returnToMainMenuPlease(); }
        });
    } // end onCreate


    public void returnToMainMenuPlease() {
        Intent intent = new Intent (this, selectWhichViewPage.class);
        startActivity(intent);
    }
}
