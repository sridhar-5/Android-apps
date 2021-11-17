package com.craftofcode.labeval3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    EditText Username, Phone, Email, Address;
    Button Register, Login, Viewall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent service = new Intent(getApplicationContext(), MyService.class);
        startService(service);

        Username = findViewById(R.id.registerName);
        Phone = findViewById(R.id.registerPhone);
        Email = findViewById(R.id.registerEmail);
        Address = findViewById(R.id.registerAddress);
        Register = findViewById(R.id.registerBtn);
        Login = findViewById(R.id.LoginBtn);
        Viewall = findViewById(R.id.ViewallBtn);

        //registration activity starting
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Username.getText().toString() != "" && Phone.getText().toString() != "" && Email.getText().toString() != "" && Address.getText().toString() != ""){
                    RegisterTheUser(Username.getText().toString(), Phone.getText().toString(), Email.getText().toString(), Address.getText().toString());
                }
            }
        });

        Viewall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), com.craftofcode.labeval3.Viewall.class);
                startActivity(intent);
            }
        });

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    private void RegisterTheUser(String username, String phone, String email, String address) {
        FirebaseFirestore database = FirebaseFirestore.getInstance();

        //creating the user object
        Map<String, String> userObject = new HashMap<String, String>();
        userObject.put("Username", username);
        userObject.put("Phone", phone);
        userObject.put("Email", email);
        userObject.put("Address", address);

        database.collection("users").add(userObject).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Toast.makeText(getApplicationContext(), "Registration Successful..! Login Please..!", Toast.LENGTH_SHORT).show();
                Username.setText("");
                Email.setText("");
                Phone.setText("");
                Address.setText("");
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(), "Failed..Please Try registering again..1", Toast.LENGTH_SHORT).show();
            }
        });
    }
}