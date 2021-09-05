package com.craftofcode.foodorderingappassignment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class FirstFragment extends Fragment {
    ListView listView;
    FragmentCommunicator communicate;
    String[] Items = {"Veg Fried Rice\t\t\t\t\t\t\t\t\t\t₹240", "Veg Manchurian\t\t\t\t\t\t\t\t\t\t₹210", "French Fries\t\t\t\t\t\t\t\t\t\t₹150", "Palak Paneer\t\t\t\t\t\t\t\t\t\t₹200", "Paneer Butter Masala\t\t\t\t\t\t\t\t\t\t₹250", "Butter Naan\t\t\t\t\t\t\t\t\t\t₹045"};
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_first, container, false);
        listView = view.findViewById(R.id.itemList);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, Items);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String SelectedItem = Items[position];
                if (communicate == null){
                    communicate = (FragmentCommunicator) getActivity();
                }
                Log.d("message",SelectedItem);
                communicate.respond(SelectedItem);
            }
        });

        return view;
    }
}