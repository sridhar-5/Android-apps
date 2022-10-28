package com.craftofcode.infinitescroll;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ProgressBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    LinearLayoutManager manager;
    ListTrailAdapter adapter;
    Boolean isScrolling = false;
    ProgressBar progressBar;
    ArrayList<String> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataList = new ArrayList<>();

        String baseString = "Hello World";
        for(int i = 0; i < 20; i++){
            dataList.add(baseString + i);
        }
        System.out.println(dataList);
        recyclerView =  findViewById(R.id.recyclerView);
        progressBar = findViewById(R.id.progBar);
        manager = new LinearLayoutManager(this);
        adapter = new ListTrailAdapter(dataList, this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if(newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL){
                    isScrolling=true;
                }
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                if(isScrolling && (manager.getChildCount() + manager.findFirstVisibleItemPosition() == manager.getItemCount())) {
                    isScrolling = false;
                    fetchData();
                }
            }
        });

    }

    public void fetchData(){
        progressBar.setVisibility(View.VISIBLE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 5; i++){
                    dataList.add("hello");
                    adapter.notifyDataSetChanged();
                    progressBar.setVisibility(View.GONE);
                }
            }
        }, 5000);
    }
}