package com.example.sampleproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button

class SecondaryDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secondary_details)

        val backButton = findViewById<Button>(R.id.button4)
        backButton?.setOnClickListener(){
            val intent = Intent(this,BasicDetails::class.java)
            startActivity(intent)
        }

        val nextButton = findViewById<Button>(R.id.button5)
        nextButton?.setOnClickListener(){
            val intent = Intent(this,FourthPage::class.java)
            startActivity(intent)
        }

        val departments = resources.getStringArray(R.array.Departments)
        val arrayAdapter = ArrayAdapter(this,R.layout.dropdown_item,departments)
        val autoCompleteTV = findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView)

        autoCompleteTV.setAdapter(arrayAdapter)
    }
}