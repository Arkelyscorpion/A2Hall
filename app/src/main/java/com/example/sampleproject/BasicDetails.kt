package com.example.sampleproject

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import com.example.sampleproject.databinding.ActivityMainBinding

class BasicDetails : AppCompatActivity() {
    private lateinit var etName : EditText
    private lateinit var etEmail : EditText
    private lateinit var etPhone : EditText
    private lateinit var nextButton : Button
    private lateinit var backButton : Button

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic_details)

        etName = findViewById(R.id.textInputEditText1)
        etEmail = findViewById(R.id.editTextTextEmailAddress1)
        etPhone = findViewById(R.id.editTextPhone1)
        val textDesignation = findViewById<TextView>(R.id.headingForDesignation)
        val radiobutton1 = findViewById<RadioButton>(R.id.radioButton1);
        val radiobutton2 = findViewById<RadioButton>(R.id.radioButton2);
        val radiobutton3 = findViewById<RadioButton>(R.id.radioButton3);
        val textOthers = findViewById<EditText>(R.id.textInputFieldForOthers)
        backButton = findViewById<Button>(R.id.button3)
        backButton?.setOnClickListener(){
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        nextButton = findViewById<Button>(R.id.button2)
        nextButton?.setOnClickListener() {
            val username= etName.text.toString().trim()
            val email= etEmail.text.toString().trim()
            val phone= etPhone.text.toString().trim()
            val otherDesignation = textOthers.text.toString().trim()
            if(username.isEmpty()||email.isEmpty()||phone.isEmpty()) {
                if(username.isEmpty()) {
                    etName.error = "Username required"
                    //return@setOnClickListener
                }
                if (email.isEmpty()) {
                    etEmail.error = "Email Required"
                    //return@setOnClickListener
                }
                if (phone.isEmpty()) {
                    etPhone.error = "Phone number Required"
                    //return@setOnClickListener
                }
                return@setOnClickListener
            }
            if((!radiobutton1.isChecked) && (!radiobutton2.isChecked) && (!radiobutton3.isChecked) && (otherDesignation.isEmpty()))
            {
                textDesignation.error = "Required field"
                return@setOnClickListener
            }
            val intent = Intent(this, SecondaryDetails::class.java)
            startActivity(intent)
        }
    }
}