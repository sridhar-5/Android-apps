package com.craftofcode.foodorderingappassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText Username;
    private EditText PhoneNumber;
    private Button LoginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Username = findViewById(R.id.nameEditText);
        PhoneNumber = findViewById(R.id.mobileNoEditText);
        LoginButton = findViewById(R.id.Login);

        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Username.getText().toString().equals("") && PhoneNumber.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Please Fill in the fields to Login", Toast.LENGTH_SHORT).show();
                } else if (Username.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Please Enter the Username", Toast.LENGTH_SHORT).show();
                } else if (PhoneNumber.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Please Enter your Phone Number", Toast.LENGTH_SHORT).show();
                } else {
                    //if both checks failed
                    Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                    intent.putExtra("Username", Username.getText().toString());
                    // for debugging
                    //Log.d("message", Username.getText().toString());
                    intent.putExtra("PhoneNumber", PhoneNumber.getText().toString());
                    startActivity(intent);
                }
            }
        });
    }
}