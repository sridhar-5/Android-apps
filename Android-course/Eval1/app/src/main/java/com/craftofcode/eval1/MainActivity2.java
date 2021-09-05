package com.craftofcode.eval1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity2 extends AppCompatActivity {
    ListView listview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Log.d("me", "dsucyiuf");
        listview = findViewById(R.id.listviewscreen2);
        String[] arrayAdap = new String[5];

        Bundle detailsFromPrevScreen = getIntent().getExtras();
        arrayAdap[0] =  detailsFromPrevScreen.getString("username");
        arrayAdap[1] = detailsFromPrevScreen.getString("fullname");
        arrayAdap[2] = detailsFromPrevScreen.getString("city");
        arrayAdap[3] = detailsFromPrevScreen.getString("email");
        arrayAdap[4] = detailsFromPrevScreen.getString("password");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,arrayAdap);
        listview.setAdapter(adapter);

    }
}