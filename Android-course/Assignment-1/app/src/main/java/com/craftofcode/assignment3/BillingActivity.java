package com.craftofcode.assignment3;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class BillingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_billing);
        Bundle UserBoughtProducts = getIntent().getExtras();
        ArrayList<Integer> UserPurchase = UserBoughtProducts.getIntegerArrayList("BillList");
        String[] ItemNames = UserBoughtProducts.getStringArray("Item available");
        double[] ItemsPrices = UserBoughtProducts.getDoubleArray("Prices");
        for(int s: UserPurchase){
            Log.d("item: ", String.valueOf(s));
        }
    }
}