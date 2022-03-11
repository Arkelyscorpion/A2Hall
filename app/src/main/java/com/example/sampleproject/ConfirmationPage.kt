package com.example.sampleproject

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.*

//data class Details(val name:String){}

class ConfirmationPage : AppCompatActivity() {
    private lateinit var database: DatabaseReference

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
        val checkSlotButton = findViewById<Button>(R.id.button12)
        val confirmButton = findViewById<Button>(R.id.button11)
        tvName.text = "NAME:    " + Details.getName()
        tvEmail.text = "EMAIL:  " + Details.getEmail()
        tvPhone.text = "CONTACT NO.:    " + Details.getPhone()
        tvDesignation.text = "DESIGNATION:   " + Details.getDesignation()
        tvDepartment.text = "DEPARTMENT:    " + Details.getDepartment()
        tvEventType.text = "EVENT TYPE: " + Details.getEventType()
        tvDegree.text = "DEGREE:" + Details.getDegree()
        tvYearOfStudy.text = "YEAR OF STUDY:    " + Details.getYearOfStudy()
        tvDate.text = "DATE:    " + Details.getDate()
        tvTime.text = "TIME:    " + Details.getStartTime() + " to " + Details.getEndTime()
        var booltiming = true

        checkSlotButton?.setOnClickListener {
            database = FirebaseDatabase.getInstance("https://a2-halls-tce-default-rtdb.asia-southeast1.firebasedatabase.app").getReference("bookingDetails")
            database.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    for (eventSnapshot in snapshot.children) {
                        var edate = eventSnapshot.child("date").getValue()
                        var estime = eventSnapshot.child("startTime").getValue()
                        var eetime = eventSnapshot.child("endTime").getValue()
                        // var condition1 = checkTimeSlots(estime.toString(),eetime.toString(),Details.getStartTime(),Details.getEndTime())
                        // var condition2 = checkTimeSlots(estime.toString(),eetime.toString(),Details.getStartTime(),Details.getEndTime())
                        booltiming = !((Details.getDate() == edate) && !checkTimeSlots(
                            estime.toString(),
                            eetime.toString(),
                            Details.getStartTime(),
                            Details.getEndTime()
                        ))
                        if (!booltiming)
                            break
                    }
                    if(booltiming) {
                        Toast.makeText(
                            applicationContext,
                            "Slot available! Click on confirm to proceed",
                            Toast.LENGTH_SHORT
                        ).show()
                        confirmButton.isEnabled = true
                    }
                    else{
                        Toast.makeText(
                            applicationContext,
                            "Slot not available! Refer slots and contact the concerned person",
                            Toast.LENGTH_SHORT
                        ).show()
                        confirmButton.isEnabled = false
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }
            })
        }

        confirmButton?.setOnClickListener{
            if(booltiming)
            {
                Details.setId(database.push().key!!)
                writeAllDetails(Details.getId()!!)
                val intent = Intent(this,ConfirmedPage::class.java)
                startActivity(intent)
            }
        }
    }

    fun writeAllDetails(id : String) {
        //PUSHING DATA INTO FIREBASE DATABASE
        database.child(id).setValue(Details)
    }

    fun checkTimeSlots(oldstart: String, oldend: String, newstart: String?,newend: String?): Boolean{
//        try {
//            val time1: Date = SimpleDateFormat("HH:mm").parse(a)
//            val calendar1 = Calendar.getInstance()
//            calendar1.time = time1
//            calendar1.add(Calendar.DATE, 1)
//            val time2: Date = SimpleDateFormat("HH:mm").parse(b)
//            val calendar2 = Calendar.getInstance()
//            calendar2.time = time2
//            calendar2.add(Calendar.DATE, 1)
//            val d: Date = SimpleDateFormat("HH:mm").parse(c)
//            val calendar3 = Calendar.getInstance()
//            calendar3.time = d
//            calendar3.add(Calendar.DATE, 1)
//            val x = calendar3.time
//            if (x.after(calendar1.time) && x.before(calendar2.time)) {
//                //checks whether the current time is between 14:49:00 and 20:11:13.
//                return true
//            }
//        } catch (e: ParseException) {
//            e.printStackTrace()
////        }
//        return false
        var bool = false
        if(newend!! >= oldstart && newend <= oldend)
            bool = true
        if(newstart!! >= oldstart && newstart <= oldend)
            bool = true
        if(oldstart!! >= newstart &&  newend >= oldend)
            bool = true
        return bool;
    }
}