package com.craftofcode.foodorderingappassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity implements FragmentCommunicator, SecondThirdFragCommunicator{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


    }

    @Override
    public void respond(String item) {
        Log.d("called", item);
        FragmentManager manage = getSupportFragmentManager();
        SecondFragment frag = (SecondFragment) manage.findFragmentById(R.id.fragment2);
        frag.RenderSelectedItemsData(item);
    }

    @Override
    public void respondSecThird(int i, ArrayList items, Fragment fragment) {
        FragmentManager manage = getSupportFragmentManager();
        FragmentTransaction ft = manage.beginTransaction();
        ft.replace(R.id.framelayout,fragment);
        ft.commit();
    }
}