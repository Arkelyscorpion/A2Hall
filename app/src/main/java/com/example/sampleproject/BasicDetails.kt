package com.example.sampleproject

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class BasicDetails : AppCompatActivity() {

    private lateinit var etName : EditText
    private lateinit var etEmail : EditText
    private lateinit var etPhone : EditText
    lateinit var sPref: SharedPreferences
    val SAVED_TEXT = "saved_text"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic_details)
        etName = findViewById(R.id.textInputEditText1)
        etEmail = findViewById(R.id.editTextTextEmailAddress1)
        etPhone = findViewById(R.id.editTextPhone1)
        val textDesignation = findViewById<TextView>(R.id.headingForDesignation)
        val radiobutton1 = findViewById<RadioButton>(R.id.radioButton1)
        val radiobutton2 = findViewById<RadioButton>(R.id.radioButton2)
        val radiobutton3 = findViewById<RadioButton>(R.id.radioButton3)
        val textOthers = findViewById<EditText>(R.id.textInputFieldForOthers)
        val nextButton = findViewById<Button>(R.id.button2)
            nextButton?.setOnClickListener() {
            val username = etName.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val phone = etPhone.text.toString().trim()
            val otherDesignation = textOthers.text.toString().trim()
            if (username.isEmpty() || email.isEmpty() || phone.isEmpty()) {
                if (username.isEmpty()) {
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

            if ((!radiobutton1.isChecked) && (!radiobutton2.isChecked) && (!radiobutton3.isChecked) && (otherDesignation.isEmpty())) {
                textDesignation.error = "Required field"
                return@setOnClickListener
            }


            Details.setName(username)
            Details.setEmail(email)
            Details.setPhone(phone)
            if(otherDesignation.isNotEmpty())
                Details.setDesignation(otherDesignation)
            else if(radiobutton1.isChecked)
                Details.setDesignation(radiobutton1.text.toString())
            else if(radiobutton2.isChecked)
                Details.setDesignation(radiobutton2.text.toString())
            else if(radiobutton3.isChecked)
                Details.setDesignation(radiobutton3.text.toString())
            val intent = Intent(this,SecondaryDetails::class.java)
            startActivity(intent)
        }
    }
//    fun saveText() {
//        sPref = getPreferences(MODE_PRIVATE)
//        val ed: SharedPreferences.Editor = sPref.edit()
//        ed.putString(SAVED_TEXT, etName.getText().toString())
//        ed.commit()
//        Toast.makeText(this, "Text saved", Toast.LENGTH_SHORT).show()
//    }
//

}