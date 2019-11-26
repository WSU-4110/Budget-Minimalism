package com.example.bm;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class mainActivity extends AppCompatActivity {

    //Mohammed
    private EditText Email;
    private EditText Password;
    private TextView Info;
    private Button Login;
    //private int counter = 5;
    private TextView userSignup;

    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Email = (EditText)findViewById(R.id.uname);
        Password = (EditText)findViewById(R.id.pass);
        //Info = (TextView)findViewById(R.id.btnInfo);
        Login = (Button) findViewById(R.id.btnLogin);
        userSignup = (TextView) findViewById(R.id.tvsignup);



        //Info.setText("No Of attempts remaining: 5");
        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);

        FirebaseUser user = firebaseAuth.getCurrentUser();

        //Mohammed
        //After click on Sign In button it will validate the user email and pass
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //assigns the text field for the email
                EditText usernameEditText = (EditText) findViewById(R.id.uname);
                String sUsername = usernameEditText.getText().toString();
                //checks if the email is empty
                if (sUsername.matches("")) {
                    //if the email is empty, outputs a message
                    Toast.makeText(mainActivity.this, "Please enter in an Email to SIGN IN ", Toast.LENGTH_SHORT).show();
                    return;
                }

                //assigns the pass word
                EditText passwordEditText2 = (EditText) findViewById(R.id.pass);
                String sUsernpass = passwordEditText2.getText().toString();
                //checks for the password if its empty
                if (sUsernpass.matches("")) {

                    //prints out message of the user did not enter in a password
                    Toast.makeText(mainActivity.this, "Please enter in a Password to SIGN IN", Toast.LENGTH_SHORT).show();
                    return;
                }
                validate(Email.getText().toString(),Password.getText().toString());


            }
        });

        //Mohamed
        //After click on Sign In button it will validate the user email and pass
        userSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mainActivity.this, signUpActivity.class));
            }
        });
    }

    private void validate (String userEmail, String userPassword){

        progressDialog.setMessage("Progressing!!!");
        progressDialog.show();
        progressDialog.dismiss();

        firebaseAuth.signInWithEmailAndPassword(userEmail,userPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> t) {
                if (t.isSuccessful()){
                    progressDialog.dismiss();
                    Toast.makeText(mainActivity.this,"Login Successfull" ,Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(mainActivity.this, homePageActivity.class));
                }else{
                    Toast.makeText(mainActivity.this,"Log in failed",Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();

                }
            }
        });
    }}