package com.example.rosnouschedule.extra

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.rosnouschedule.R
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bell_schedule)

        // Найти TextView
        val dateTextView: TextView = findViewById(R.id.dateTextView)

        // Получить текущую дату
        val currentDate = Date()

        // Форматировать дату
        val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        val formattedDate = dateFormat.format(currentDate)

        // Отобразить дату в TextView
        dateTextView.text = formattedDate
    }
}
