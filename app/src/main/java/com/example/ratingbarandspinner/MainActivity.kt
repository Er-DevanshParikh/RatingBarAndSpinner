package com.example.ratingbarandspinner

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.view.get

class MainActivity : AppCompatActivity() {
    val colors: Array<String> = arrayOf("Red","Green","Blue","Yellow","Black","Cyan","Dkgray","Ltgray","Magenta")
    var select_color : String? = null
    lateinit var spncolor: Spinner
    lateinit var ratingbar: RatingBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ratingbar=findViewById(R.id.rb_ratingbar)
        spncolor = findViewById(R.id.spn_color)

        //For Spinner
        val arrayAdapter = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,colors)
        spncolor.adapter=arrayAdapter
        spncolor.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                select_color=parent?.getItemAtPosition(position).toString()
                Toast.makeText(this@MainActivity, "Your Selected $select_color" , Toast.LENGTH_SHORT).show()
                when(select_color) {
                    "Red"->
                    {
                        ratingbar.setBackgroundColor(-65536)
                    }
                    "Green"->{
                        ratingbar.setBackgroundColor(-16711936)
                    }
                    "Blue" ->{
                        ratingbar.setBackgroundColor(-16776961)
                    }
                    "Black" -> {
                        ratingbar.setBackgroundColor(-16777216)
                    }
                    "Cyan" -> {
                        ratingbar.setBackgroundColor(-16711681)
                    }
                    "Dkgray" -> {
                        ratingbar.setBackgroundColor(-12303292)
                    }
                    "Ltgray" -> {
                        ratingbar.setBackgroundColor(-3355444)
                    }
                    "Magenta" -> {
                        ratingbar.setBackgroundColor(-65281)
                    }
                    "Yellow" -> {
                        ratingbar.setBackgroundColor(-256)
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }


        //For Rating Bar
        ratingbar.rating = 2.5f
        ratingbar.stepSize = .5f
        ratingbar.onRatingBarChangeListener = RatingBar.OnRatingBarChangeListener { _, p1, _ -> Toast.makeText(this, "Given rating is: $p1", Toast.LENGTH_SHORT).show()}
//        ratingbar.setBackgroundColor(Color.YELLOW)


    }
}