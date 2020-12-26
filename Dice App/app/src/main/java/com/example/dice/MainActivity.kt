package com.example.dice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

/**
 * this activity allows the uset to roll the dice and see the result on the screen
 *
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //creating a button object here
        val rolldice:Button = findViewById(R.id.button)

        /**
         * short notes on how the id's in android are assigned
         * Android automatically assigns ID numbers to the resources in your app.
         * For example, the Roll button has a resource ID, and the string for the button text also has a resource ID.
         *  Resource IDs are of the form R.<type>.<name>; for example, R.string.roll. For View IDs, the <type> is id,
         * for example, R.id.button.
        */

        //adding an action listener to make the button work

        rolldice.setOnClickListener{
            roll_dice_action()
        }
    }

    /**
     * this function contains the logic to roll the dice and display the result on the screen
     * and display a pop-up toast if the output of the user roll is greater than 4
     */
    private fun roll_dice_action() {
        val generate = Dice(6)
        val diceroll = generate.rolldice()

        val dice_image:ImageView = findViewById(R.id.imageView)

        //changes the image of the dice when it is rolled

        when(diceroll){
            1 -> dice_image.setImageResource(R.drawable.dice_1)
            2 -> dice_image.setImageResource(R.drawable.dice_2)
            3 -> dice_image.setImageResource(R.drawable.dice_3)
            4 -> dice_image.setImageResource(R.drawable.dice_4)
            5 -> dice_image.setImageResource(R.drawable.dice_5)
            6 -> dice_image.setImageResource(R.drawable.dice_6)
        }

        dice_image.contentDescription = diceroll.toString()

        /**
         * toast is like a pop up in html but from the down part of the device
         * create a toast object and call the method show in its class to show itself
         */
        if(diceroll > 4){
            val toast = Toast.makeText(this,"Congratulations Dude",Toast.LENGTH_SHORT)
            toast.show()
        }
        else{
            val toast = Toast.makeText(this,"Sorry try again",Toast.LENGTH_SHORT)
            toast.show()
        }
    }
}

/**
 * the class dice which actually is responsible for the random number that is being generated
 */
class Dice(private val no_of_sides:Int){
    fun rolldice():Int{
        return (1..no_of_sides).random()
    }
}