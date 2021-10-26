package com.example.bm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class initialScreen extends AppCompatActivity {

    private Button signin;
    private Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial_screen);

        signin=(Button)findViewById(R.id.signinButton);
        signup=(Button)findViewById(R.id.signupButton);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(initialScreen.this, mainActivity.class);
                startActivity(intent);
                initialScreen.this.finish();
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(initialScreen.this, signUpActivity.class);
                startActivity(intent);
                initialScreen.this.finish();
            }
        });
    }
}