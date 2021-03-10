package com.amrita.justjava;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public int no_of_coffees;

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        display(no_of_coffees);
    }

    public void increment(View view){
        no_of_coffees = no_of_coffees + 1;
        display(no_of_coffees);
    }

    public void decrement(View view){
        no_of_coffees = no_of_coffees - 1;
        if (no_of_coffees < 0 ){
            Toast toast_message = Toast.makeText(getApplicationContext(),"Number of coffees can't be Negative",Toast.LENGTH_SHORT);
            toast_message.show();
            no_of_coffees = 0;
        }
        display(no_of_coffees);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantityContent);
        quantityTextView.setText("" + number);
        displayPrice(number);
    }

    private void displayPrice(int number){
        TextView pricetextview = (TextView) findViewById(R.id.price);
        pricetextview.setText(NumberFormat.getCurrencyInstance().format(number*5));
    }
}
