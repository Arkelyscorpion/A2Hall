package com.example.sampleproject

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
//import android.widget.DatePicker
import android.widget.TextView
import androidx.annotation.RequiresApi
//import java.text.SimpleDateFormat
//import java.time.DayOfWeek
import java.util.*

class FifthPage : AppCompatActivity() {

    private lateinit var dateText : TextView
    private lateinit var dateButton : Button
    private lateinit var timeText : TextView
    private lateinit var timeButton : Button

    @SuppressLint("SetTextI18n")
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fifth_page)

        dateButton = findViewById(R.id.button8)
        dateText = findViewById(R.id.textView3)
        timeButton = findViewById(R.id.button9)
        timeText = findViewById(R.id.textView4)
        val backButton= findViewById<Button>(R.id.button13)
        val nextButton = findViewById<Button>(R.id.button10)

        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        dateButton.setOnClickListener {
            val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                // Display Selected date in TextView
                dateText.setText("" + dayOfMonth + "-" + (monthOfYear+1) + "-" + year)
            }, year, month, day)
            dpd.getDatePicker().setMinDate(c.getTimeInMillis());
            dpd.show()
        }

        timeButton.setOnClickListener{
            val startHour = c.get(Calendar.HOUR_OF_DAY)
            val startMinute = c.get(Calendar.MINUTE)

            TimePickerDialog(this, { view, hourOfDay, minute ->
                timeText.text = "$hourOfDay: $minute"
            }, startHour, startMinute, false).show()
        }
        backButton.setOnClickListener{
            val intent = Intent(this, SecondaryDetails::class.java)
            startActivity(intent)
        }

        nextButton?.setOnClickListener() {

            Details.setDate(dateText.text.toString())
            Details.setTime(timeText.text.toString())
            val intent = Intent(this, ConfirmationPage::class.java)
            startActivity(intent)
        }
    }

}
