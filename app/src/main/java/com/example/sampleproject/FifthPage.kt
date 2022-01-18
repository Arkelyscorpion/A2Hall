package com.example.sampleproject

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import androidx.annotation.RequiresApi
import java.text.SimpleDateFormat
import java.util.*

class FifthPage : AppCompatActivity() {

    private lateinit var dateText : TextView
    private lateinit var dateButton : Button
    private lateinit var timeText : TextView
    private lateinit var timeButton : Button

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fifth_page)

        dateButton = findViewById(R.id.button8)
        dateText = findViewById(R.id.textView3)
        timeButton = findViewById(R.id.button9)
        timeText = findViewById(R.id.textView4)
        val nextButton = findViewById<Button>(R.id.button10)

        val myCalendar = Calendar.getInstance()

        val datePicker = DatePickerDialog.OnDateSetListener{ view, year, month, dayOfMonth ->
            myCalendar.set(Calendar.YEAR, year)
            myCalendar.set(Calendar.MONTH, month)
            myCalendar.set(Calendar.DAY_OF_MONTH,dayOfMonth)
            updateLable(myCalendar)
        }

        dateButton.setOnClickListener {
            DatePickerDialog(this, datePicker, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
            myCalendar.get(Calendar.DAY_OF_MONTH)).show()
        }

        timeButton.setOnClickListener{
            val startHour = myCalendar.get(Calendar.HOUR_OF_DAY)
            val startMinute = myCalendar.get(Calendar.MINUTE)

            TimePickerDialog(this, TimePickerDialog.OnTimeSetListener{view, hourOfDay, minute ->
                timeText.setText("$hourOfDay: $minute")
            }, startHour, startMinute, false).show()
        }

        nextButton?.setOnClickListener() {

            Details.setDate(dateText.text.toString())
            Details.setTime(timeText.text.toString())
            val intent = Intent(this, ConfirmationPage::class.java)
            startActivity(intent)
        }
    }

    private fun updateLable(myCalendar: Calendar) {
        val myFormat = "dd-mm-yyyy"
        val sdf = SimpleDateFormat(myFormat, Locale.UK)
        dateText.setText(sdf.format(myCalendar.time))
    }
}
