package com.example.rosnouschedule.extra

import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.datepicker.MaterialDatePicker
import java.text.SimpleDateFormat
import java.util.*

object DisplayDates {

    //эту функцию не тестировал!!!
    fun CurrentDate (
        textView: TextView,
        activity: androidx.fragment.app.FragmentActivity
        ){
        // Создаем календарь с выбором даты
        val calendar = MaterialDatePicker.Builder.datePicker()
            .setTitleText("Выберите дату")
            .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
            .build()

        // Открываем календарь
        calendar.show(activity.supportFragmentManager, "MATERIAL_DATE_PICKER")

        // Обрабатываем выбор даты
        calendar.addOnPositiveButtonClickListener { selection ->
            // Преобразуем выбранную дату в нужный формат
            val selectedDate = Date(selection)
            val sdf = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
            val formattedDate = sdf.format(selectedDate)

            // Отображаем выбранную дату
            textView.text = formattedDate
        }
    }

    // Функция для отображения текущей даты в TextView без вызова календаря
    fun setCurrentDate(textView: TextView) {
        val sdf = SimpleDateFormat("dd MMMM yyyy", Locale.getDefault())
        val currentDate = sdf.format(Date())
        textView.text = currentDate
    }
}

/*      Это то, что было в BellScheduleActivity

        // Найти TextView
        val dateTextView: TextView = findViewById(R.id.dateTextView)

        // Получить текущую дату
        val currentDate = Date()

        // Форматировать дату
        val dateFormat = DisplayDate("dd MMMM yyyy", Locale.getDefault())
        val formattedDate = dateFormat.format(currentDate)

        // Отобразить дату в TextView
        dateTextView.text = formattedDate */