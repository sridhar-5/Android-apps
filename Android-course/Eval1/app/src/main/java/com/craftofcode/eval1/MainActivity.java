package com.craftofcode.eval1;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    String user_name;
    String pass_word;
    String full_name;
    CheckBox c1;
    Boolean valid;
    String[] cities = {"Coimbatore","Vijayawada","Kochi","Bangalore","Delhi","Lucknow"};
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    TextView error;
    Button button;
    EditText username;
    EditText fullname;
    EditText email;
    EditText password;
    EditText cityna;
    String email_value;
    int count = 0;
    AutoCompleteTextView atv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        error = findViewById(R.id.error);
        button = findViewById(R.id.registerbutton);
        username = findViewById(R.id.uname);
        fullname = findViewById(R.id.fname);
        email = findViewById(R.id.email);
        password = findViewById(R.id.pwd);
        cityna = findViewById(R.id.city);
        user_name = username.getText().toString();
        pass_word = password.getText().toString();
        full_name = fullname.getText().toString();

        EditText password = findViewById(R.id.pwd);
        atv = findViewById(R.id.city);
        c1 = findViewById(R.id.cb);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_selectable_list_item,cities);

        atv.setAdapter(adapter);
        atv.setThreshold(0);
        atv.setTextColor(Color.WHITE);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerClicked(v);
            }
        });
        atv.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                atv.showDropDown();
                return false;
            }
        });

        email_value = email.getText().toString();

        valid = true;

        if(!email_value.matches(emailPattern)){
            valid = false;
            error.setText(R.string.email_error);
        }

    }


    public void registerClicked(View view) {

        if(email_value.isEmpty())
        {
            valid = false;
            error.setText(R.string.email_empty_error);
        }

        if(user_name.isEmpty())
        {
            valid = false;
            error.setText(R.string.error_username);
        }

        else if(pass_word.isEmpty())
        {
            valid = false;
            error.setText(R.string.error_pwd);
        }

        else if(full_name.isEmpty())
        {
            valid = false;
            error.setText(R.string.error_fullname);
        }

        if(valid==false){
            error.setTextColor(Color.parseColor("#ff0000"));
        }

        if(c1.isChecked())
        {
            valid = true;
        }
        else
        {
            valid = false;
            Toast.makeText(getApplicationContext(),"checkbox must be checked in order to proceed",Toast.LENGTH_LONG).show();
        }


        if(valid==true)
        {
            Intent intent = new Intent(getApplicationContext(),MainActivity2.class);
            intent.putExtra("username",username.getText().toString());
            intent.putExtra("password",password.getText().toString());
            intent.putExtra("fullname",fullname.getText().toString());
            intent.putExtra("email",email.getText().toString());
            intent.putExtra("city",cityna.getText().toString());
            startActivity(intent);
        }

        else{
            count++;
        }

        if(count>3){
            error.setText(R.string.exceeded_error);
        }

    }
}