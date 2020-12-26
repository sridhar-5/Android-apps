package com.example.dice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

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
     */
    private fun roll_dice_action() {
        val generate = Dice(6)
        val diceroll = generate.rolldice()

        val resultTextView : TextView = findViewById(R.id.textView)
        resultTextView.text = diceroll.toString()
    }
}

class Dice(private val no_of_sides:Int){
    fun rolldice():Int{
        return (1..no_of_sides).random()
    }
}