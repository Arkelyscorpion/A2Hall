package com.example.sampleproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView

class FourthPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fourth_page)
        val textDegree = findViewById<TextView>(R.id.headingForDegree)
        val textYear = findViewById<TextView>(R.id.headingForYear)
        val radiobutton = findViewById<RadioButton>(R.id.radioButton);
        val radiobutton4 = findViewById<RadioButton>(R.id.radioButton4);
        val radiobutton6 = findViewById<RadioButton>(R.id.radioButton6);
        val radiobutton7 = findViewById<RadioButton>(R.id.radioButton7);
        val radiobutton8 = findViewById<RadioButton>(R.id.radioButton8);
        val radiobutton9 = findViewById<RadioButton>(R.id.radioButton9);
        val radiobutton10 = findViewById<RadioButton>(R.id.radioButton10);
        val nextButton = findViewById<Button>(R.id.button6)
        val backButton = findViewById<Button>(R.id.button7)

        backButton?.setOnClickListener() {
            val intent = Intent(this, SecondaryDetails::class.java)
            startActivity(intent)
        }
        nextButton?.setOnClickListener() {
            if((!radiobutton.isChecked) && (!radiobutton4.isChecked))
            {
                textDegree.error = "Required field"
                return@setOnClickListener
            }
            if((!radiobutton6.isChecked) && (!radiobutton7.isChecked) && (!radiobutton8.isChecked) && (!radiobutton9.isChecked) && (!radiobutton10.isChecked) )
            {
                textYear.error = "Required field"
                return@setOnClickListener
            }
            if(radiobutton.isChecked)
                Details.setDegree(radiobutton.text.toString())
            else if(radiobutton4.isChecked)
                Details.setDegree(radiobutton4.text.toString())

            if(radiobutton6.isChecked)
                Details.setYearOfStudy(radiobutton6.text.toString())
            else if(radiobutton7.isChecked)
                Details.setYearOfStudy(radiobutton7.text.toString())
            else if(radiobutton8.isChecked)
                Details.setYearOfStudy(radiobutton8.text.toString())
            else if(radiobutton9.isChecked)
                Details.setYearOfStudy(radiobutton9.text.toString())
            else if(radiobutton10.isChecked)
                Details.setYearOfStudy(radiobutton10.text.toString())

            val intent = Intent(this, FifthPage::class.java)
            startActivity(intent)
        }



    }
}
