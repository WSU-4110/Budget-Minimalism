package com.example.budget_min;



import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Spinner dropdownmenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dropdownmenu = (Spinner) findViewById(R.id.spinner4);
        List<String> list = new ArrayList<>();
        list.add("Rent");
        list.add("Water Bill");
        list.add("Internet Bill");
        list.add("Electric Bill");
        list.add("Coffee");
        list.add("Movie");
        list.add("UBER");
        list.add("OTHER");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);


        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        dropdownmenu.setAdapter(adapter);

        dropdownmenu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String Ivalue=parent.getItemAtPosition(position).toString();
                Toast.makeText(MainActivity.this, "Selection "+Ivalue,Toast.LENGTH_SHORT).show();
            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
