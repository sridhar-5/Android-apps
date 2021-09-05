package com.craftofcode.foodorderingappassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity implements Varibles {

    Button button1, button2, button3, button4;
    public String MobileNumber;
    public String Username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Bundle bundle = getIntent().getExtras();

        ArrayList<String> UserItems = bundle.getStringArrayList("ItemList");
        int count = bundle.getInt("count");
        button1 = findViewById(R.id.smsbill);
        button3 = findViewById(R.id.contactus);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            //send sms
            public void onClick(View v) {
                String msg = "Hello!" + Username + "This is an sms of your Bill! \n. Your Bill Amount is : " +findTotalCost(UserItems);
                Intent intent = new Intent(getApplicationContext(),Success.class );
                PendingIntent pi = PendingIntent.getActivity(getApplicationContext(),0,intent,0);
                SmsManager smsManager = SmsManager.getDefault();
                if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(getParent(), new String[]{Manifest.permission.SEND_SMS}, 111);
                }
                smsManager.sendTextMessage(MobileNumber, null, msg, pi, null);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:" + "7569353633"));
                //contact us call the customer care
                startActivity(intent);
            }
        });

    }

    public int findTotalCost(ArrayList<String> Selected){
        int total = 0;
        for(int i = 0;i < Selected.size();i++){
            total = total + Integer.parseInt(Selected.get(i).substring(Selected.get(i).length() - 3,Selected.get(i).length()));
        }
        return total;
    }

    @Override
    public void Variables(String Username, String Mobile) {
        this.MobileNumber = Mobile;
        this.Username = Username;
    }
}