// WeeklyScheduleActivity.kt
package com.example.rosnouschedule

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rosnouschedule.data.WeeklyScheduleItem
import com.example.rosnouschedule.adapters.WeeklyScheduleAdapter
import com.example.rosnouschedule.extra.DisplayDates
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WeeklyScheduleActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var weeklyScheduleAdapter: WeeklyScheduleAdapter
    private lateinit var currentDate: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weekly_schedule)

        recyclerView = findViewById(R.id.recyclerViewWeeklySchedule)
        recyclerView.layoutManager = LinearLayoutManager(this)
        currentDate = findViewById(R.id.dateTextView)

        weeklyScheduleAdapter = WeeklyScheduleAdapter(emptyList())
        recyclerView.adapter = weeklyScheduleAdapter

        DisplayDates.setCurrentDate(currentDate)
        loadWeeklySchedule()
    }

    private fun loadWeeklySchedule() {
        val apiService = RetrofitClient.apiService
        apiService.getWeeklySchedule().enqueue(object : Callback<List<WeeklyScheduleItem>> {
            override fun onResponse(
                call: Call<List<WeeklyScheduleItem>>,
                response: Response<List<WeeklyScheduleItem>>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        weeklyScheduleAdapter.updateData(it)
                    }
                } else {
                    Toast.makeText(this@WeeklyScheduleActivity, "Ошибка загрузки данных", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<WeeklyScheduleItem>>, t: Throwable) {
                Toast.makeText(this@WeeklyScheduleActivity, "Ошибка сети", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
