package com.craftofcode.assignment3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText NameField, MobileField,addressField;
    Button ValidateButton, RegisterButton, ClearTextButton;
    boolean ValidationStatus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NameField = findViewById(R.id.nameEditText);
        MobileField = findViewById(R.id.mobileNoEditText);
        addressField = findViewById(R.id.addressEditText);
        ValidateButton = findViewById(R.id.validateButton);
        RegisterButton = findViewById(R.id.RegisterId);
        ClearTextButton = findViewById(R.id.cleartextid);

        ValidateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validateButtonFunctionality(v)){
                    ValidationStatus = true;
                    Toast ValdationSuccessToast = Toast.makeText(getApplicationContext(), "All data validated, proceed to register",Toast.LENGTH_SHORT);
                    ValdationSuccessToast.show();
                }
            }
        });

        RegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegisterButtonFunctionality(v);
            }
        });


    }

    public boolean validateButtonFunctionality(View v){
        String NameFieldString = NameField.getText().toString();
        boolean NameFieldStringValidation = false, MobileFieldStringValidation = false;
        //check if the string entered only contains alphabets
        if(CheckIfOnlyAlphabets(NameFieldString)){
            NameFieldStringValidation = true;
        }

        String MobileNumberString = MobileField.getText().toString();
        if(CheckMobileNumberLength(MobileNumberString)){
            MobileFieldStringValidation = true;
        }

        return MobileFieldStringValidation && NameFieldStringValidation;
    }

    public void RegisterButtonFunctionality(View v){
        if(ValidationStatus){
            Intent nextActivity = new Intent(getApplicationContext(),MainActivity2.class);
            startActivity(nextActivity);
        }else{
            Toast ValidationStatusToast = Toast.makeText(MainActivity.this, "Validate first before registering",Toast.LENGTH_SHORT);
            ValidationStatusToast.show();
        }
    }

    public boolean CheckIfOnlyAlphabets(String theFieldString){
        theFieldString = theFieldString.toLowerCase();
        char[] characterArray = theFieldString.toCharArray();

        for (char ch : characterArray) {
            if (!(ch >= 'a' && ch <= 'z')) {
                return false;
            }
        }
        return true;
    }

    public boolean CheckMobileNumberLength(String Mobileno){
        return Mobileno.length() == 10;
    }
}