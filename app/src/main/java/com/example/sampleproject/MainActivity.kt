package com.example.sampleproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.EditText
import java.io.File
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.button)
        val button2 = findViewById<Button>(R.id.btnCheckSlot)

        /*
        operations to be performed
        when user tap on the button
        */
        button?.setOnClickListener()
        {
            //intent is used to link one page to another
            val intent = Intent(this, BasicDetails::class.java)
            // start your next activity
            startActivity(intent)
        }

        button2?.setOnClickListener()
        {
            val intent= Intent(this, BookedSlots::class.java)
            startActivity(intent)
            finish()
        }
    }
}