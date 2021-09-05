package com.craftofcode.assignment3;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class BillingActivity extends AppCompatActivity {
    ListView billList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_billing);
        Bundle UserBoughtProducts = getIntent().getExtras();
        ArrayList<Integer> UserPurchase = UserBoughtProducts.getIntegerArrayList("BillList");
        String[] ItemNames = UserBoughtProducts.getStringArray("Item available");
        double[] ItemsPrices = UserBoughtProducts.getDoubleArray("Prices");
        //for debugging purpose
        for(int s: UserPurchase){
            Log.d("item: ", String.valueOf(s));
        }
        billList = findViewById(R.id.lv);
        String[] ItemsUserPurchased = new String[UserPurchase.size()];
        double[] ItemPricesUserPurchased = new double[UserPurchase.size()];
        String[] ItemPricesUserPurchased2 = new String[UserPurchase.size()];
        int i = 0;
        for(int s:UserPurchase){
            ItemsUserPurchased[i] = ItemNames[s];
            i++;
        }
        i = 0;
        for(int s:UserPurchase){
            ItemPricesUserPurchased[i] = ItemsPrices[s];
            ItemPricesUserPurchased2[i] = ItemsUserPurchased[i] + "\t\t\t\t     " + "     \t\t\t\t₹"+ String.valueOf(ItemsPrices[s]);
            i++;
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.bill_list_layout,R.id.Itemname,ItemPricesUserPurchased2);

        billList.setAdapter(adapter);

        TextView totalprice;
        totalprice = findViewById(R.id.Total);
        double Total = 0;
        for(int s: UserPurchase){
            Total += ItemsPrices[s];
        }
        totalprice.setText("Total: ₹" + String.valueOf(Total));
    }
}