package com.amrita.lab1;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button button2;
    Button button3,button4;
    public int increment;
    TextView textview;
    RadioGroup radiobuttons;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button2 = findViewById(R.id.one);
        button3 = findViewById(R.id.two);
        button4 = findViewById(R.id.three);

        textview = findViewById(R.id.textview1);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                increment++;
                if (increment > 0){
                    textview.setTextColor(Color.GREEN);
                }else{
                    textview.setTextColor(Color.RED);
                }
                textview.setText(" " + increment);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                increment--;
                if(increment < 0){
                    textview.setTextColor(Color.RED);
                }else{
                    textview.setTextColor(Color.GREEN);
                }
                textview.setText(" "+increment);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View fullview = findViewById(R.id.fullview);
                fullview.setBackgroundColor(Color.BLACK);
            }
        });
        radiobuttons = findViewById(R.id.radiogroup1);
        radiobuttons.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            View fullbackground = findViewById(R.id.fullview);
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.selena){
                    fullbackground.setBackgroundColor(Color.RED);
                }else if (checkedId == R.id.taylor){
                    fullbackground.setBackgroundColor(Color.BLACK);
                }else if(checkedId == R.id.kendell){
                    fullbackground.setBackgroundColor(Color.YELLOW);
                }else{
                    fullbackground.setBackgroundColor(Color.GREEN);
                }
            }
        });
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("increment", 0);
    }

    @Override
    public void onRestoreInstanceState(@Nullable Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        savedInstanceState.getInt("increment");
        textview.setText(" "+ increment);
    }

}