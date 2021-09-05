package com.craftofcode.foodorderingappassignment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class SecondFragment extends Fragment {
    ListView listView;
    Button CheckOutButton;
    SecondThirdFragCommunicator communicator;
    ArrayList<String> SelectedItems = new ArrayList<String>();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        listView = view.findViewById(R.id.itemList2);
        return view;
    }

    public void RenderSelectedItemsData(String i){
        SelectedItems.add(i);
        TextView countView = getActivity().findViewById(R.id.count);
        countView.setText("Count: " + SelectedItems.size());
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,SelectedItems);
        listView.setAdapter(adapter);

        CheckOutButton = getActivity().findViewById(R.id.checkout);
        CheckOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = SelectedItems.size();
                if (communicator == null){
                    communicator = (SecondThirdFragCommunicator)getActivity();
                }

                communicator.respondSecThird(count, SelectedItems,new ThirdFragment());
            }
        });

    }
}