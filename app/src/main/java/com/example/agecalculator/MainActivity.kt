package com.example.agecalculator

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import android.widget.Toast
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.ageBtn)
        btn.setOnClickListener { view ->
            printAge(view)
        }

    }

    private fun printAge(view: View) {

        val myCalender = Calendar.getInstance()

        val year = myCalender.get(Calendar.YEAR)
        val month = myCalender.get(Calendar.MONTH)
        val day = myCalender.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(
            this, DatePickerDialog.OnDateSetListener { view, year, month, day ->
                val selectedDate = "$day/${month + 1}/$year"
                findViewById<TextView>(R.id.date).text = selectedDate

                val dob = Calendar.getInstance()
                dob.set(year, month, day)

                var age = myCalender.get(Calendar.YEAR) - dob.get(Calendar.YEAR)

                if (myCalender.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR)) {
                    age--
                }

                findViewById<TextView>(R.id.result).text = "Your age is $age"
            },
            year,
            month,
            day
        ).show()
    }
}