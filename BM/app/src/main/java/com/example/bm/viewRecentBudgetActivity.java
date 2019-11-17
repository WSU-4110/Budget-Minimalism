package com.example.bm;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import javax.annotation.Nullable;

public class viewRecentBudgetActivity extends AppCompatActivity {

    public static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 1;
    private FloatingActionButton back;
    private dataViewModel dataViewModel;
    private static final String TAG = "ListDataActivity";

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_recent_budget_activity);

        // Mitchell
        RecyclerView recyclerView = findViewById(R.id.recview);
        final descriptionsAdapter adapter = new descriptionsAdapter(this);
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