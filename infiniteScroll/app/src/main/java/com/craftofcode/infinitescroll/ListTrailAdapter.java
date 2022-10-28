package com.craftofcode.infinitescroll;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListTrailAdapter extends RecyclerView.Adapter<ListTrailAdapter.infiteScrollViewHolder>{

    public Context context;
    public ArrayList<String> dataList;

    public ListTrailAdapter(ArrayList<String> data, Context context){
        this.context = context;
        this.dataList = data;
        System.out.println("Hello from const" +dataList);
    }

    @Override
    public infiteScrollViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.scroll_item, parent, false);
        return new infiteScrollViewHolder(view);
    }

    @Override
    public void onBindViewHolder(infiteScrollViewHolder holder, int position) {
        holder.textView.setText(dataList.get(position));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class infiteScrollViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        public infiteScrollViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.txtItem);
        }
    }
}

