package com.example.sampleproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.*

class SecondaryDetails : AppCompatActivity() {

    private lateinit var radiobutton1 : RadioButton
    private lateinit var radiobutton2 : RadioButton
    private lateinit var nextButton : Button
    private lateinit var backButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secondary_details)
        val departments = resources.getStringArray(R.array.Departments)
        val arrayAdapter = ArrayAdapter(this,R.layout.dropdown_item,departments)
        val autoCompleteTV = findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView)
        val textOtherEvent = findViewById<EditText>(R.id.textInputFieldForOthers)
        val textEventType = findViewById<TextView>(R.id.headingForEvent)
        radiobutton1 = findViewById(R.id.radioButton)
        radiobutton2 = findViewById(R.id.radioButton4)
        nextButton = findViewById(R.id.button5)
        nextButton?.setOnClickListener(){
            val department = autoCompleteTV.text.toString().trim()
            val otherEvent = textOtherEvent.text.toString().trim()
            if(department.isEmpty()){
                autoCompleteTV.error = "Choose department"
                return@setOnClickListener
            }
            if((!radiobutton1.isChecked) && (!radiobutton2.isChecked) && (otherEvent.isEmpty())){
                textEventType.error = "Required field"
                return@setOnClickListener
            }
            Details.setDepartment(department)

            if(otherEvent.isNotEmpty()) {
                Details.setEventType(otherEvent)
                val intent = Intent(this, FourthPage::class.java)
                startActivity(intent)
            }
            else if(radiobutton2.isChecked) {
                Details.setEventType(radiobutton2.text.toString())
                Details.setDegree("-NA-")
                Details.setYearOfStudy("-NA-")
                val intent = Intent(this, FifthPage::class.java)
                startActivity(intent)
            }
            else if(radiobutton1.isChecked){
                Details.setEventType(radiobutton1.text.toString())
                val intent = Intent(this, FourthPage::class.java)
                startActivity(intent)
            }
        }
        autoCompleteTV.setAdapter(arrayAdapter)
    }
}