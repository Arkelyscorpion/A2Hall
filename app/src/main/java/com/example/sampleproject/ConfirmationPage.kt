package com.example.sampleproject

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
//data class Details(val name:String){}

class ConfirmationPage : AppCompatActivity() {
    private lateinit var database : DatabaseReference
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmation_page)
        val tvName = findViewById<TextView>(R.id.textViewName)
        val tvEmail = findViewById<TextView>(R.id.textViewEmail)
        val tvPhone = findViewById<TextView>(R.id.textViewPhone)
        val tvDesignation = findViewById<TextView>(R.id.textViewDesignation)
        val tvDepartment = findViewById<TextView>(R.id.textViewDepartment)
        val tvEventType = findViewById<TextView>(R.id.textViewEventType)
        val tvDegree = findViewById<TextView>(R.id.textViewDegree)
        val tvYearOfStudy = findViewById<TextView>(R.id.textViewYearOfStudy)
        val tvDate = findViewById<TextView>(R.id.textViewDate)
        val tvTime = findViewById<TextView>(R.id.textViewTime)
        val backButton= findViewById<Button>(R.id.button12)
        val confirmButton= findViewById<Button>(R.id.button11)
        tvName.text = "NAME:    "+ Details.getName()
        tvEmail.text = "EMAIL:  "+ Details.getEmail()
        tvPhone.text = "CONTACT NO.:    "+ Details.getPhone()
        tvDesignation.text = "DESIGNATION:   "+ Details.getDesignation()
        tvDepartment.text = "DEPARTMENT:    "+ Details.getDepartment()
        tvEventType.text = "EVENT TYPE: "+ Details.getEventType()
        tvDegree.text = "DEGREE:"+ Details.getDegree()
        tvYearOfStudy.text = "YEAR OF STUDY:    "+ Details.getYearOfStudy()
        tvDate.text = "DATE:    "+ Details.getDate()
        tvTime.text = "TIME:    "+ Details.getStartTime() + " to " + Details.getEndTime()

        backButton.setOnClickListener{
            val intent = Intent(this, FifthPage::class.java)
            startActivity(intent)
        }
        confirmButton.setOnClickListener {
            database = FirebaseDatabase.getInstance("https://a2-halls-tce-default-rtdb.asia-southeast1.firebasedatabase.app").getReference("bookingDetails")
            Details.setId(database.push().key!!)
            writeAllDetails(Details.getId()!!)
        }
    }

    fun writeAllDetails(id : String) {
        //PUSHING DATA INTO FIREBASE DATABASE
        database.child(id).setValue(Details)
    }
}