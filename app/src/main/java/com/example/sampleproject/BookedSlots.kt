package com.example.sampleproject

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

class BookedSlots : AppCompatActivity() {

    private lateinit var database : DatabaseReference
    private lateinit var eventRecyclerView : RecyclerView
    private lateinit var eventArrayList : ArrayList<Event>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booked_slots)
        eventRecyclerView = findViewById(R.id.eventList)
        eventRecyclerView.layoutManager = LinearLayoutManager(this)
        eventRecyclerView.setHasFixedSize(true)
        eventArrayList = arrayListOf<Event>()
        getEventData()


    }

    private fun getEventData() {
        database = FirebaseDatabase.getInstance("https://a2-halls-tce-default-rtdb.asia-southeast1.firebasedatabase.app").getReference("bookingDetails")
        database.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    for (eventSnapshot in snapshot.children){
                        val user = eventSnapshot.getValue(Event::class.java)
                        eventArrayList.add(user!!)
                    }
                    eventRecyclerView.adapter = EventAdapter(eventArrayList)
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