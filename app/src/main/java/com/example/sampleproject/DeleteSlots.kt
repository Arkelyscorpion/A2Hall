package com.example.sampleproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.database.*

class DeleteSlots : AppCompatActivity() {
    private lateinit var database : DatabaseReference
    private lateinit var eventRecyclerView : RecyclerView
    private lateinit var eventArrayList : ArrayList<Event>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delete_slots)
        eventRecyclerView = findViewById(R.id.eventDeleteList)
        eventRecyclerView.layoutManager = LinearLayoutManager(this)
        eventRecyclerView.setHasFixedSize(true)
        eventArrayList = arrayListOf<Event>()
        getEventData()
    }

    private fun getEventData() {
        database = FirebaseDatabase.getInstance("https://a2-halls-tce-default-rtdb.asia-southeast1.firebasedatabase.app").getReference("bookingDetails")
        database.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    for (eventSnapshot in snapshot.children){
                        if(eventSnapshot.child("bookerEmail").value == Details.getBookerEmail()) {
                            val user = eventSnapshot.getValue(Event::class.java)
                            eventArrayList.add(user!!)
                        }
                    }
                    eventRecyclerView.adapter = EventDeleteAdapter(eventArrayList)
                }
                else {
                    Toast.makeText(
                        applicationContext,
                        "CURRENTLY NO BOOKINGS",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(
                    applicationContext,
                    "Please check your internet connection and try again",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }
}