package com.example.sampleproject
import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.TimePicker
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import java.util.*

class FifthPage : AppCompatActivity() {

    private lateinit var dateChipGroup: ChipGroup
    private lateinit var dateButton : Button
    private lateinit var startTimeText : TextView
    private lateinit var endTimeText : TextView
    private lateinit var startTimeButton : Button
    private lateinit var endTimeButton : Button

    @SuppressLint("SetTextI18n")
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fifth_page)

        dateButton = findViewById(R.id.button8)
        dateChipGroup = findViewById(R.id.dateChipGroup)
        startTimeButton = findViewById(R.id.button9)
        endTimeButton = findViewById(R.id.button14)
        startTimeText = findViewById(R.id.textView4)
        endTimeText = findViewById(R.id.textView5)
        val nextButton = findViewById<Button>(R.id.button10)
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)
        val mStartTimePicker: TimePickerDialog
        val mEndTimePicker: TimePickerDialog
        val hour = c.get(Calendar.HOUR_OF_DAY)
        val minute = c.get(Calendar.MINUTE)
        val dates = Vector<String>()

        mStartTimePicker = TimePickerDialog(this, object : TimePickerDialog.OnTimeSetListener {
            override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
                startTimeText.setText(String.format("%d:%d", hourOfDay, minute))
            }
        }, hour, minute, false)

        mEndTimePicker = TimePickerDialog(this, object : TimePickerDialog.OnTimeSetListener {
            override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
                endTimeText.setText(String.format("%d:%d", hourOfDay, minute))
            }
        }, hour, minute, false)

        dateButton.setOnClickListener {
            val dpd = DatePickerDialog(
                this,
                DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                    // Display Selected date in TextView
                    addChip("" + dayOfMonth + "-" + (monthOfYear + 1) + "-" + year)
                    dates.addElement("" + dayOfMonth + "-" + (monthOfYear + 1) + "-" + year)
                },
                year,
                month,
                day
            )
            dpd.getDatePicker().setMinDate(c.getTimeInMillis())
            dpd.show()
        }
        startTimeButton.setOnClickListener{
            mStartTimePicker.show()
        }

        endTimeButton.setOnClickListener{
            mEndTimePicker.show()
        }

        nextButton?.setOnClickListener() {
            Dates.setDates(dates)
            Details.setStartTime(startTimeText.text.toString())
            Details.setEndTime(endTimeText.text.toString())
            val intent = Intent(this, ConfirmationPage::class.java)
            startActivity(intent)
        }
    }

    private fun addChip(text: String){
        val chip = Chip(this)
        chip.text = text

        chip.isCloseIconVisible = true

        //chip.setChipIconResource(R.drawable.ic_baseline_android_24)

        chip.setOnCloseIconClickListener{
            dateChipGroup.removeView(chip)
        }

        dateChipGroup.addView(chip)
    }
}
