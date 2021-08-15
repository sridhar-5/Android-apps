package com.craftofcode.assignment3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.craftofcode.assignment3.adapter.ItemListAdapter;
import com.craftofcode.assignment3.interfaces.globalVarsInterface;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.LinkedList;

public class MainActivity2 extends AppCompatActivity implements globalVarsInterface{
    public RecyclerView recyclerView;
    public FloatingActionButton proceedToBilling;
    public LinkedList<String> ItemsOrdered = new LinkedList<>();
    public LinkedList<Integer> ItemsOrderedPrice = new LinkedList<>();
    public ItemListAdapter adapter;
    public String[] ItemNamesInStore = {"Peppy paneer Pizza", "Paneer Makhni Pizza", "Cheese Burst Pizza", "Corn Pizza","papperoni pizza","farm house pizza", "vegie deilight pizza","chicken pizza", "tandoori pizza","custom pizza"};
    public double[] PricesOfItemsInStore = {250,260,240.5,350,312,250,260,240.5,350,312};
    private LinkedList<String> ItemNameList = new LinkedList<>();
    private LinkedList<Integer> ItemImage = new LinkedList<>();
    private LinkedList<Double> ItemPrice = new LinkedList<>();
    ListView ItemListView;
    int[] PizzaImages = {
            R.drawable.p1,
            R.drawable.p2,
            R.drawable.p3,
            R.drawable.p4,
            R.drawable.p5,
            R.drawable.p6,
            R.drawable.p7,
            R.drawable.p8,
            R.drawable.p9,
            R.drawable.p10
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        for(int i = 0; i< ItemNamesInStore.length; i++){
            ItemNameList.addLast(ItemNamesInStore[i]);
            ItemImage.addLast(PizzaImages[i]);
            ItemPrice.addLast(PricesOfItemsInStore[i]);
        }
        recyclerView = findViewById(R.id.recyclerView);
        adapter = new ItemListAdapter(this, ItemNameList, ItemImage, ItemPrice);
        recyclerView.setAdapter(adapter);
//        recyclerView.setOnClickListener(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        proceedToBilling = findViewById(R.id.fab);
        proceedToBilling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent BillingActivty = new Intent(getApplicationContext(), BillingActivity.class);
                BillingActivty.putExtra("BillList",UserClickedItems);
                BillingActivty.putExtra("Item available", ItemNamesInStore);
                BillingActivty.putExtra("Prices", PricesOfItemsInStore);
                startActivity(BillingActivty);
            }
        });
    }

//    @Override
//    public void onClick(View v) {
//        int position = recyclerView.getChildLayoutPosition(v);
//        Toast toast = Toast.makeText(getApplicationContext(),position, Toast.LENGTH_SHORT);
//        ItemsOrdered.addLast(ItemNameList.get(position));
//        ItemsOrderedPrice.addLast(ItemsOrderedPrice.get(position));
//    }
}