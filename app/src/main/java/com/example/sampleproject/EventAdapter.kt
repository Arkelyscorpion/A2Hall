package com.example.sampleproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EventAdapter(private val eventList: ArrayList<Event>) :
    RecyclerView.Adapter<EventAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.event_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentitem= eventList[position]

        holder.Name.text= currentitem.name
        holder.Date.text= currentitem.date
        holder.Time.text= currentitem.time
        holder.Contact.text= currentitem.phone
    }

    override fun getItemCount(): Int {
        return eventList.size
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val Name :TextView = itemView.findViewById(R.id.tvName)
        val Date : TextView = itemView.findViewById(R.id.tvDate)
        val Time : TextView = itemView.findViewById(R.id.tvTime)
        val Contact : TextView = itemView.findViewById(R.id.tvContact)
    }
}