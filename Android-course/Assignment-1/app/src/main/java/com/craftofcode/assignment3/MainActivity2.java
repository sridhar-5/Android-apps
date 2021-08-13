package com.craftofcode.assignment3;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.craftofcode.assignment3.adapter.ItemListAdapter;

import java.util.LinkedList;

public class MainActivity2 extends AppCompatActivity {
    public RecyclerView recyclerView;
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

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}