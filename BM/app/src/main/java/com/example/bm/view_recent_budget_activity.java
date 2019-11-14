package com.example.bm;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import javax.annotation.Nullable;

public class view_recent_budget_activity extends AppCompatActivity {

    private static final String TAG = "ListDataActivity";
    DatabaseHelper instantiatedHelper;
    private ListView mitchList;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_recent_budget_activity);
        mitchList = (ListView) findViewById(R.id.listview);
        instantiatedHelper = new DatabaseHelper(this);
        populateListView();
    }

    private void populateListView() {
        Log.d(TAG, "populateListView: Displaying data in the ListView.");
        Cursor data = instantiatedHelper.getData();
        ArrayList<String> listData = new ArrayList<>();
        while(data.moveToNext()){
            listData.add(data.getString(1));
        }

        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listData);
        mitchList.setAdapter(adapter);


        mitchList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String itemThing = adapterView.getItemAtPosition(i).toString();
                Log.d(TAG, "onItemClick: You Clicked on " + itemThing);

                Cursor data = instantiatedHelper.getItem(itemThing); //get the id associated with that name
                int itemID = -1;
                while (data.moveToNext()) {
                    itemID = data.getInt(1);
                }
                if (itemID > -1) {
                    Log.d(TAG, "onItemClick: The ID is: " + itemID);
                    Intent intent = new Intent(view_recent_budget_activity.this, income_inputscreen.class);
                    //intent.putExtra("id", itemID);
                    //intent.putExtra("name", name);
                    startActivity(intent);
                }
                }
        });
    }

}