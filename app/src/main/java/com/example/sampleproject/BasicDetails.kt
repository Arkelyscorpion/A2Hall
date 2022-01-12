package com.example.sampleproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import com.example.sampleproject.databinding.ActivityMainBinding

class BasicDetails : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic_details)

        val backButton = findViewById<Button>(R.id.button3)
        backButton?.setOnClickListener(){
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        val nextButton = findViewById<Button>(R.id.button2)
        nextButton?.setOnClickListener() {
            val intent = Intent(this, SecondaryDetails::class.java)
            startActivity(intent)
        }
    }
}