package com.androiddevelopmentLectures

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.androiddevelopmentLectures.databinding.ActivityMainBinding

class MainActivity:AppCompatActivity(){
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //setting the activity for the calculate_tip button

        binding.calculateButton.setOnClickListener { calculateTip() }
    }



    private fun calculateTip() {
        //extracting the text in the edit text view and using it
        val StringinTextfield = binding.costOfService.text.toString()

        //converting it into double now
        val costindoubletype = StringinTextfield.toDoubleOrNull()

        //if the entered edit text view is left null then the app crashes without this code here
        /**
         * enters a valid amount for the cost
         * taps Calculate to calculate the tip
         * deletes the cost
         * taps Calculate again?
         * now the result is the tip amount of the previous case shows out which creates confusion to the user so to solve this bug
         * binding.tipresult.text should be null so that the cost is evaluated to zero when converted to double
         */
        if(costindoubletype == null){
            binding.tipResult.text = ""
            return
        }

        //now extracting the percent of the discount from the radio button selected

        val selectedRadio = binding.tipOption.checkedRadioButtonId

        val tip_percent = when(selectedRadio){
            R.id.twenty_percent_cost -> 0.20
            R.id.fifteen_percent_of_cost -> 0.15
            else -> 0.15
        }

        var tip_cost = tip_percent*costindoubletype

        val roundUp = binding.roundUpSwitch.isChecked
        if(roundUp){
            tip_cost = kotlin.math.ceil(tip_cost)
        }

        val formatted_tip = java.text.NumberFormat.getCurrencyInstance().format(tip_cost)
        binding.tipResult.text = getString(R.string.tip_amount,formatted_tip)

    }
}