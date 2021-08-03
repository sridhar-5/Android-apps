package com.amrita.application2;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView listView;
    String []array = {"Monday","Tuesday","Wednesday","Monday","Tuesday","Wednesday","Tuesday","Wednesday","Monday","Tuesday","Wednesday","Tuesday","Wednesday","Monday","Tuesday","Wednesday"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        listView = findViewById(R.id.list);
        Bundle here = getIntent().getExtras();
        String username = here.getString("user");
        String Password = here.getString("password");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, array);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TextView view1 = (TextView) view;
        Toast toast = Toast.makeText(getApplicationContext(), ((TextView) view).getText().toString(),Toast.LENGTH_SHORT);
        toast.show();
        Log.d("message: ",view1.getText().toString());
    }
}