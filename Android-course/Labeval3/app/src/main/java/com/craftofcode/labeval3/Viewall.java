package com.craftofcode.labeval3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class Viewall extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewall);

        TextView AllUsersDisplay = findViewById(R.id.allusers);

        FirebaseFirestore database = FirebaseFirestore.getInstance();

        database.collection("users")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        String AllUsers = "";

                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                AllUsers = AllUsers + document.getData().toString() + "\n";
                            }

                            AllUsersDisplay.setText(AllUsers);

                        } else {
                            Toast.makeText(getApplicationContext(), "Error Fetching the data", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}