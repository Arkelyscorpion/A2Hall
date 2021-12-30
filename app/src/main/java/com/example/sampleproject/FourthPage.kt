package com.example.sampleproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class FourthPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fourth_page)

        val nextButton= findViewById<Button>(R.id.button6)
        val backButton = findViewById<Button>(R.id.button7)

        backButton?.setOnClickListener(){
            val intent = Intent(this,SecondaryDetails::class.java)
            startActivity(intent)
        }
        nextButton?.setOnClickListener(){
            val intent = Intent(this,FifthPage::class.java)
            startActivity(intent)
        }

    }
}