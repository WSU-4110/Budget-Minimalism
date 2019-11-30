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

import com.example.bm.userInterfaceJava.LoginPresenter;
import com.example.bm.userInterfaceJava.LoginView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class mainActivity extends AppCompatActivity implements LoginView {

    //Mohammed
    private EditText Email;
    private EditText Password;
    private TextView Info;
    private Button Login;
    //private int counter = 5;
    private TextView userSignup;

    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;
    private LoginPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Email = (EditText)findViewById(R.id.uname);
        Password = (EditText)findViewById(R.id.pass);
        Login = (Button) findViewById(R.id.btnLogin);
        userSignup = (TextView) findViewById(R.id.tvsignup);

        //Mohammed Rahin Unit testing
        presenter = new LoginPresenter(this, new com.example.bm.homePageActivity());

        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);
        FirebaseUser user = firebaseAuth.getCurrentUser();

        //Mohammed
        //After click on Sign In button it will validate the user email and pass
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Mohammed Rahin Unit test
                presenter.onClick();

                //assigns the text field for the email
//                EditText userEmailEditText = (EditText) findViewById(R.id.uname);
//                String sUserEmail = userEmailEditText.getText().toString();
                //checks if the email is empty
//                if (sUserEmail.isEmpty()) {
//                    //if the email is empty, outputs a message
//                    //Toast.makeText(mainActivity.this, "Please enter in an Email to SIGN IN ", Toast.LENGTH_SHORT).show();
//                    userEmailEditText.setError("Please Enter a Valid Email");
//                    return;
//                }
//
//                //assigns the pass word
//                EditText passwordEditText2 = (EditText) findViewById(R.id.pass);
//                String sUserpass = passwordEditText2.getText().toString();
//                //checks for the password if its empty
//                if (sUserpass.isEmpty()) {
//                    //prints out message of the user did not enter in a password
//                    //Toast.makeText(mainActivity.this, "Please enter in a Password to SIGN IN", Toast.LENGTH_SHORT).show();
//                    passwordEditText2.setError("Please Enter a Valid Password");
//                    return;
//                }
                //validate(Email.getText().toString(),Password.getText().toString());
            }
        });

        //Mohamed
        //After click on Sign In button it will validate the user email and pass
        userSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mainActivity.this, com.example.bm.signUpActivity.class));
            }
        });
    }

    private void validate (String userEmail, String userPassword){

        firebaseAuth.signInWithEmailAndPassword(userEmail,userPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> t) {
                if (t.isSuccessful()){
                    progressDialog.dismiss();
                    Toast.makeText(mainActivity.this,"Login Successfull" ,Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(mainActivity.this, com.example.bm.homePageActivity.class));
                }else{
                    Toast.makeText(mainActivity.this,"Log in failed",Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();

                }
            }
        });
    }

    @Override
    public String getUserEmail() {
        return Email.getText().toString();
    }

    @Override
    public void showUserEmailError(int resID) {
        Email.setError(getString(resID));
    }

    @Override
    public String getUserPass() {
        return Password.getText().toString();
    }

    @Override
    public void showUserPassError(int resID) {
        Password.setError(getString(resID));
    }

    @Override
    public void startHomePageAvtivity() {
        new Intent(mainActivity.this, com.example.bm.homePageActivity.class);
    }

    @Override
    public void showLoginError(int resID) {
        Toast.makeText(mainActivity.this,getString(resID),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void signUpActivity() {
        startActivity(new Intent(mainActivity.this, com.example.bm.signUpActivity.class));
    }


}