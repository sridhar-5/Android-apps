package com.craftofcode.assignment3.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.craftofcode.assignment3.R;

import java.util.LinkedList;

public class ItemListAdapter extends RecyclerView.Adapter<ItemListAdapter.ItemViewHolder>{
    private final LinkedList<String> ItemName;
    private final LinkedList<Integer> ItemImage;
    private final LinkedList<Double> ItemPricell;
    private LayoutInflater ItemLayoutInflater;

    class ItemViewHolder extends RecyclerView.ViewHolder{
        public ImageView ImageItem;
        public TextView Itemname;
        public TextView ItemPrice;
        final ItemListAdapter ItemAdapter;

        public ItemViewHolder(View ItemView, ItemListAdapter ItemAdapter){
            super(ItemView);
            ImageItem = ItemView.findViewById(R.id.image_item);
            Itemname = ItemView.findViewById(R.id.item_title);
            ItemPrice = ItemView.findViewById(R.id.Item_price);
            this.ItemAdapter = ItemAdapter;
        }
    }

    public ItemListAdapter(Context context, LinkedList<String> ItemName, LinkedList<Integer> ItemImage, LinkedList<Double> ItemPricell){
        ItemLayoutInflater = LayoutInflater.from(context);
        this.ItemName = ItemName;
        this.ItemImage = ItemImage;
        this.ItemPricell = ItemPricell;
    }
    public ItemListAdapter.ItemViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View ItemView = ItemLayoutInflater.inflate(R.layout.list_item,parent,false);
        return new ItemViewHolder(ItemView, this);
    }

    @Override
    public void onBindViewHolder(ItemListAdapter.ItemViewHolder holder, int position) {
        String CurrentItemName = ItemName.get(position);
        int CurrentImage = ItemImage.get(position);
        double CurrentItemPrice = ItemPricell.get(position);
        holder.ImageItem.setImageResource(CurrentImage);
        holder.Itemname.setText(CurrentItemName);
        holder.ItemPrice.setText(String.valueOf(CurrentItemPrice));
    }

    @Override
    public int getItemCount() {
        return ItemName.size();
    }
}
