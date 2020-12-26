package com.example.dice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //creating a button object here
        val rolldice:Button = findViewById(R.id.button)

        /*
        Android automatically assigns ID numbers to the resources in your app.
        For example, the Roll button has a resource ID, and the string for the button text also has a resource ID.
        Resource IDs are of the form R.<type>.<name>; for example, R.string.roll. For View IDs, the <type> is id,
        for example, R.id.button.
        */

        //adding an action listener to make the button work

        rolldice.setOnClickListener{
            val toast = Toast.makeText(this,"Dice Rolled!",Toast.LENGTH_SHORT)
            toast.show()
        }
    }
}