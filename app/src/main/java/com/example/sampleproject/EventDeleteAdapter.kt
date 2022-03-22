package com.example.sampleproject

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.databinding.DataBindingUtil.setContentView
import androidx.recyclerview.widget.RecyclerView
import com.example.sampleproject.databinding.ActivityDeleteSlotsBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class EventDeleteAdapter(context: Context, private val eventList: ArrayList<Event>) :
    RecyclerView.Adapter<EventDeleteAdapter.MyViewHolder>() {
    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val Name : TextView
        val Date : TextView
        val startTime : TextView
        val endTime : TextView
        val Contact : TextView
        val deleteEvent : ImageButton
        val id : TextView
        init{
            Name = itemView.findViewById(R.id.tvName)
            Date = itemView.findViewById(R.id.tvDate)
            startTime = itemView.findViewById(R.id.tvStartTime)
            endTime = itemView.findViewById(R.id.tvEndTime)
            Contact = itemView.findViewById(R.id.tvContact)
            deleteEvent = itemView.findViewById(R.id.imageButton)
            id = itemView.findViewById(R.id.tvId)
            deleteEvent.setOnClickListener{
                /*AlertDialog.Builder(context)
                    .setTitle("Delete")
                    .setIcon(R.drawable.ic_baseline_warning_24)
                    .setMessage("Are you sure delete the event booking?")
                    .setPositiveButton("Yes"){
                            dialog,_->
                        removeEvent(id.text as String)
                        eventList.removeAt(adapterPosition)
                        notifyDataSetChanged()
                        Toast.makeText(cont
                                ext,"Deleted this Information",Toast.LENGTH_SHORT).show()
                        dialog.dismiss()
                    }
                    .setNegativeButton("No"){
                            dialog,_->
                        dialog.dismiss()
                    }
                    .create()
                    .show()*/
                eventList.removeAt(adapterPosition)
                removeEvent(id.text as String)
                notifyDataSetChanged()
            }
        }

        private fun removeEvent(id: String) {
            val reference = FirebaseDatabase.getInstance("https://a2-halls-tce-default-rtdb.asia-southeast1.firebasedatabase.app").getReference("bookingDetails")
            reference.child(id).removeValue()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.event_delete_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentitem= eventList[position]
        holder.Name.text= currentitem.name
        holder.Date.text= currentitem.date
        holder.startTime.text= currentitem.startTime
        holder.endTime.text= currentitem.endTime
        holder.Contact.text= currentitem.phone
        holder.id.text= currentitem.id
    }

    override fun getItemCount(): Int {
        return eventList.size
    }

}