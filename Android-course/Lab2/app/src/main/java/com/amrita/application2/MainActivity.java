package com.amrita.application2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText username;
    EditText password;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.input);
        password = findViewById(R.id.input2);
        login = findViewById(R.id.transition);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernameText = username.getText().toString();
                String PasswordText = password.getText().toString();

                Intent intent  =new Intent(getApplicationContext(), MainActivity2.class);
                intent.putExtra("user", usernameText);
                intent.putExtra("password", PasswordText);
                startActivity(intent);
            }
        });
    }
}