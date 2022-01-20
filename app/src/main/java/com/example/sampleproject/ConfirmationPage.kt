package com.example.sampleproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import java.io.File
import java.lang.Exception

//data class Details(val name:String){}

class ConfirmationPage : AppCompatActivity() {
    private lateinit var database : DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmation_page)
        var tvDetails = findViewById<TextView>(R.id.textView5)
        //tvDetails.text =  Details.getDetails()
        database = FirebaseDatabase.getInstance("https://a2-halls-tce-default-rtdb.asia-southeast1.firebasedatabase.app").getReference("bookingDetails")
        Details.setId(database.push().key!!)
        writeallDetails(Details.getId()!!)


    }

    fun writeallDetails(id : String) {
        //PUSHING DATA INTO FIREBASE DATABASE
        database.child(id).setValue(Details)
    }
}