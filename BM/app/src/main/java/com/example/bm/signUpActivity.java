package com.example.bm;

import androidx.appcompat.app.AppCompatActivity;

import androidx.annotation.NonNull;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class signUpActivity extends AppCompatActivity {

    private EditText userName, userPassword, userEmail, confirmPassword;
    private Button regButton;
    private TextView userLogin;
    //Database helper
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        //this will set up the UI Views
        setupUIViews();

        //Database helper
        firebaseAuth = FirebaseAuth.getInstance();

        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validate()){
                    //upload the data to database
                    String user_name = userName.getText().toString().trim();
                    String user_email = userEmail.getText().toString().trim();
                    String user_password = userPassword.getText().toString().trim();

                    firebaseAuth.createUserWithEmailAndPassword(user_email,user_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(signUpActivity.this, "Registration successful", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(signUpActivity.this, com.example.bm.mainActivity.class));
                            }else{
                                Toast.makeText(signUpActivity.this, "Registration failed", Toast.LENGTH_SHORT).show();

                            }
                        }

                    });

                }
            }
        });

        //once the user click on Sign in it will take them to Home Page Activity
        userLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(signUpActivity.this, com.example.bm.mainActivity.class));
            }
        });

    }

    //This is a sign up page
    private void setupUIViews(){
        userName = (EditText)findViewById (R.id.etUserName);
        userPassword = (EditText)findViewById (R.id.etUserPassword);
        userEmail = (EditText)findViewById (R.id.etUserEmail);
        regButton = (Button) findViewById (R.id.etSignup);
        userLogin = (TextView) findViewById (R.id.tvUserLogin);
        confirmPassword = (EditText) findViewById(R.id.etUserPassword2);

    }
    private Boolean validate(){
        Boolean result = false;

        String name = userName.getText().toString();
        String password = userPassword.getText().toString();
        String email = userEmail.getText().toString();
        String confirmPasswordValue = confirmPassword.getText().toString();

        if (name.isEmpty() || password.isEmpty() || email.isEmpty() || confirmPasswordValue.isEmpty()) {
            Toast.makeText(this,"Please enter all the required details.", Toast.LENGTH_SHORT).show();
        }
        else{
            if (!password.equals(confirmPasswordValue)) {
                Toast.makeText(this,"Passwords do not match.", Toast.LENGTH_SHORT).show();
            }
            else {
                result = true;
            }
        }

        return result;

    }
}
