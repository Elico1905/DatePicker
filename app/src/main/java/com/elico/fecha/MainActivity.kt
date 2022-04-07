package com.elico.fecha

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fecha:TextView = findViewById(R.id.fecha)

        val myCalendar = Calendar.getInstance()

        val datePicker = DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
            myCalendar.set(Calendar.YEAR,year)
            myCalendar.set(Calendar.MONTH,month)
            myCalendar.set(Calendar.DAY_OF_MONTH,dayOfMonth)
            val myFormat = "dd/MM/yyyy"
            val resultado = SimpleDateFormat(myFormat, Locale.US)
            fecha.setText(resultado.format(myCalendar.time))
        }

        fecha.setOnClickListener {
            val c = Calendar.getInstance() //fecha de hoy

            // para cambiar el color, se debe de cambiar el color al tema myThema_DatePicker
            var picker = DatePickerDialog(this,R.style.myThema_DatePicker,datePicker,myCalendar.get(Calendar.YEAR),myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH))

            //picker.datePicker.maxDate = c.timeInMillis //fecha maxima que se puede selecionar

            //picker.datePicker.minDate = c.timeInMillis //fecha maxima que se puede selecionar

            picker.show()
        }

    }
}