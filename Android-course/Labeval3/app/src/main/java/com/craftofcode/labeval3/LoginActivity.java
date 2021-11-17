package com.craftofcode.labeval3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class LoginActivity extends AppCompatActivity {

    EditText Username, Phone;
    Button Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Username = findViewById(R.id.username);
        Phone = findViewById(R.id.Phone);
        Login = findViewById(R.id.LoginBtn);

        String username = Username.getText().toString();
        String phone = Phone.getText().toString();

        FirebaseFirestore database = FirebaseFirestore.getInstance();


        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username != "" && phone != ""){
                    database.collection("users")
                            .get()
                            .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                                @Override
                                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                    String AllUsers = "";
                                    AtomicBoolean notfound = new AtomicBoolean(true);
                                    Map<String, Object> doc = null;
                                    if (task.isSuccessful()) {
                                        for (QueryDocumentSnapshot document : task.getResult()) {
                                            doc = new HashMap<String, Object>(document.getData());

                                            doc.forEach((key, Value) -> {
//                                                if(key.equals(username) && Value.toString().equals(Phone)){
//                                                    System.out.println(key +"/n" + Value.toString());
//                                                    notfound.set(false);
//                                                }
                                                if(key.equals("Username") && Value.toString().equals(username)){
                                                    System.out.println(Value.toString());
                                                    if(key.equals("Phone") && Value.toString().equals(Phone)){
                                                        notfound.set(false);
                                                    }
                                                }

                                            });
                                        }
                                        Intent intent = new Intent(getApplicationContext(), grocery.class);
                                        System.out.println(notfound);

                                        if (notfound.get()){
                                            Toast.makeText(getApplicationContext(), "Logged in", Toast.LENGTH_SHORT).show();
                                            startActivity(intent);
                                        }else{
                                            startActivity(intent);
                                        }

                                    } else {
                                        Toast.makeText(getApplicationContext(), "Error Fetching the data", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }
            }
        });
    }
}