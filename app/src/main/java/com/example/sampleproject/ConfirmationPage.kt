package com.example.sampleproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import java.io.File
import java.lang.Exception

//data class Details(val name:String){}

class ConfirmationPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmation_page)
        var tvDetails = findViewById<TextView>(R.id.textView5)
        tvDetails.text =  Details.getDetails()
    }
}