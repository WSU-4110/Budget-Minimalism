package com.example.bm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class settingsPage extends AppCompatActivity {

    // Mitchell: this may be redundant to declare objects like this, need to check
    private Button SetIncomeCategories;
    private Button setExpenseCategories;
    private FloatingActionButton back; //this object is for the back button
    private Button developerInfo;
    Button logout;

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

        developerInfo = (Button) findViewById(R.id.DeveloperInfo);
        developerInfo.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {sendToDeveloperInfoPage(); }
        }));
        logout= findViewById(R.id.signout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentn=new Intent(settingsPage.this,mainActivity.class);
                startActivity(intentn);
                finish();
                Toast.makeText(settingsPage.this,"Successfully Logout",Toast.LENGTH_SHORT).show();
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

    public void sendToDeveloperInfoPage() {
        Intent intent = new Intent(this, developerInfoPage.class);
        startActivity(intent);
    }



}