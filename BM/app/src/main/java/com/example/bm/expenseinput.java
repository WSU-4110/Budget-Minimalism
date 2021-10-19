package com.example.bm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class expenseinput extends AppCompatActivity {

    EditText editTextdescription;
    EditText editTextprice;
    Spinner spinner12;
    Button buttonsubmit;
    DatabaseReference databaseTransection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        editTextdescription=(EditText)findViewById(R.id.editText);
        editTextprice=(EditText)findViewById(R.id.editText2);
        spinner12=(Spinner)findViewById(R.id.spinner4);

        buttonsubmit=(Button)findViewById(R.id.expenseSubmit);
        databaseTransection= FirebaseDatabase.getInstance().getReference("transection");


        buttonsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addTransection();

                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("message");

                myRef.setValue("Hello, World!");

            }
        });



    } // end onCreate

    private void addTransection(){

        String transectiondescription=editTextdescription.getText().toString().trim();
        String transectionprice=editTextprice.getText().toString().trim();
        String transectioncategory=spinner12.getSelectedItem().toString();
        if(!TextUtils.isEmpty(transectionprice)){
            String id=databaseTransection.push().getKey();

            transaction transection1=new transaction (id,transectiondescription,transectionprice,transectioncategory);

            databaseTransection.setValue(transection1);






        }else {
            Toast.makeText(this, "Enter the price ", Toast.LENGTH_LONG).show();

        }
    }


}
