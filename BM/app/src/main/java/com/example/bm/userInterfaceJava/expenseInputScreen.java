package com.example.bm;





import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class expenseInputScreen extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private dataViewModel dataViewModel2;
    private FloatingActionButton back;   //create object for back button
    private EditText DescriptionBox;
    private Button submitButton;
    private EditText amountEditText;



    EditText editTextdescription;
    EditText editTextprice;
    Spinner spinner12;
    Button buttonsubmit;
    DatabaseReference databaseTransection;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense_inputscreen);

        // Mitchell:
        // This code connects the xml back button and the java object
        // then it creates a click listener, so that when we click on it
        // the button calls the returnToMainMenuPlease()
        back = (FloatingActionButton) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnToMainMenuPlease();
            }
        });

        // Mitchell
        // This code enables the categories spinner on the expense input page
        Spinner spinner = findViewById(R.id.spinner4); // create new spinner object
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.expenseCategoriesArray, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);


        DescriptionBox = findViewById(R.id.editText);
        submitButton = (Button) findViewById(R.id.expenseSubmit);
        dataViewModel2 = new ViewModelProvider(this).get(dataViewModel.class);
        amountEditText = findViewById(R.id.editText2);


        submitButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String description = DescriptionBox.getText().toString();
                String amount = amountEditText.getText().toString();
                String sendIt ="- "+amount+" "+description+ " on "+date;
                if (!sendIt.equals("")) {
                    transactionEntity newTransaction2 = new transactionEntity(sendIt);
                    dataViewModel2.insert(newTransaction2);
                    returnToMainMenuPlease();
                } else {
                    toastMessage("Please fill in all fields");
                }
            }
        });

        editTextdescription=(EditText)findViewById(R.id.editText);
        editTextprice=(EditText)findViewById(R.id.editText2);
        spinner12=(Spinner)findViewById(R.id.spinner4);

        buttonsubmit=(Button)findViewById(R.id.expenseSubmit);
        databaseTransection= FirebaseDatabase.getInstance().getReference("transection");


        buttonsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addTransection();

            }
        });



    } // end onCreate

    private void addTransection(){

        String transectiondescription=editTextdescription.getText().toString().trim();
        String transectionprice=editTextprice.getText().toString().trim();
        String transectioncategory=spinner12.getSelectedItem().toString();
        if(!TextUtils.isEmpty(transectionprice)){
            String id=databaseTransection.push().getKey();

            transection transection1=new transection (id,transectiondescription,transectionprice,transectioncategory);

            databaseTransection.child(id).setValue(transection1);






        }else {
            Toast.makeText(this, "Enter the price ", Toast.LENGTH_LONG).show();

        }
    }



    // Mitchell Fenner
    // setting up a date object
    java.util.Date date = new java.util.Date();

    // Mitchell
    // Function which returns user to main menu from the expense input screen
    public void returnToMainMenuPlease() {
        Intent intent = new Intent (this, homePageActivity.class);
        startActivity(intent);
    }

    // Used to want a toast message on category selection but its just annoying now
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //String text = parent.getItemAtPosition(position).toString();
        ///oast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();

    }

    // Mitchell
    // Implemented from AdapterView.OnItemSelectedListener
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

    // Toast message function for data entry input
    private void toastMessage(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
}