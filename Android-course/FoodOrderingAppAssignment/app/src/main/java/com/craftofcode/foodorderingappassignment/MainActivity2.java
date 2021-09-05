package com.craftofcode.foodorderingappassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity implements FragmentCommunicator{
    public String MobileNumber;
    public String Username;
    Varibles var;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Bundle bundle = getIntent().getExtras();
        MobileNumber = bundle.getString("PhoneNumber");
        Username = bundle.getString("Username");
        //var.Variables(MobileNumber,Username);
    }

    @Override
    public void respond(String item) {
        Log.d("called", item);
        FragmentManager manage = getSupportFragmentManager();
        SecondFragment frag = (SecondFragment) manage.findFragmentById(R.id.fragment2);
        frag.RenderSelectedItemsData(item);
    }

}