package com.example.bm;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;

public class viewRecentBudgetActivity extends AppCompatActivity {

    public static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 1;
    private FloatingActionButton back;
    private dataViewModel dataViewModel;
    private static final String TAG = "ListDataActivity";

    private TextView mTotal;
    private DatabaseReference mDatabase;


    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_recent_budget_activity);
        //finds and initializes the total amount text view place

        mTotal = (TextView)findViewById(R.id.totalAmtid);
        // creates a referance to the child or the root of the database which
        // i have saved up as transaction because it saves any expense transaction

        mDatabase= FirebaseDatabase.getInstance().getReference().child("transaction");

        //creates an event listener which finds all the prices and sums them up
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                int sum=0;
                // in a for loop, we go through each one and add the price attribute

                for (DataSnapshot ds:dataSnapshot.getChildren()){
                    Map<String, Object> map=(Map<String,Object>) ds.getValue();
                    // looks for price in the database to add
                    Object price=map.get("price");
                    // coverting string to int using javas built in method parseint

                    int pValue=Integer.parseInt(String.valueOf(price));
                    sum+=pValue;
                    // sums up and sends to the text field in the xml file.
                    mTotal.setText(String.valueOf(sum));


                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        // Mitchell
        // This code sets up the recycler view to return database information
        RecyclerView recyclerView = findViewById(R.id.recview);
        final transactionsAdapter adapter = new transactionsAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Mitchell
        // Enables back button on the view page
        back = (FloatingActionButton) findViewById(R.id.viewback);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnToMainMenuPlease();
            }
        });

        // Mitchell
        // Observer for the LiveData, calls the onChanged() method when observed data changes
        dataViewModel = new ViewModelProvider(this).get(dataViewModel.class);
        dataViewModel.getAllWords().observe(this, new Observer<List<transactionEntity>>() {
            @Override
            public void onChanged(@androidx.annotation.Nullable final List<transactionEntity> words) {
                adapter.setWords(words);
            }
        });

    } // end onCreate

    // Mitchell
    // to return user to the view selection page
    public void returnToMainMenuPlease() {
        Intent intent = new Intent (this, selectWhichViewPage.class);
        startActivity(intent);
    }
/*
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NEW_WORD_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            transactionEntity word = new transactionEntity(data.getStringExtra(incomeInputScreen.EXTRA_REPLY));
            dataViewModel.insert(word);
        }
    }

 */
}