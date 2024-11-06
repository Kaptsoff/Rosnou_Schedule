package com.example.rosnouschedule

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.rosnouschedule.adapters.BellScheduleAdapter
import com.example.rosnouschedule.data.BellScheduleItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.example.rosnouschedule.extra.DisplayDates
import com.example.rosnouschedule.WeeklyScheduleActivity

class BellScheduleActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: BellScheduleAdapter
    private lateinit var swipeRefreshBellSchedule: SwipeRefreshLayout
    //private lateinit var backButton: Button
    private lateinit var currentDate: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bell_schedule)

        recyclerView = findViewById(R.id.recyclerViewBellSchedule)
        swipeRefreshBellSchedule = findViewById(R.id.swipeRefreshBellSchedule)
        //backButton = findViewById(R.id.backButtonBellSchedule)
        currentDate = findViewById(R.id.dateTextView)

        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = BellScheduleAdapter(emptyList())
        recyclerView.adapter = adapter

        swipeRefreshBellSchedule.setOnRefreshListener {
            fetchBellSchedules()
            Toast.makeText(this, "Данные обновлены", Toast.LENGTH_SHORT).show()
            swipeRefreshBellSchedule.isRefreshing = false
        }

        /* Кнопка возврата заменена на swipeRefresh

        backButton.setOnClickListener {
            // Возвращаемся на MainActivity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }*/

        DisplayDates.setCurrentDate(currentDate)
        fetchBellSchedules()
    }

    private fun fetchBellSchedules() {
        RetrofitClient.apiService.getBellSchedules().enqueue(object : Callback<List<BellScheduleItem>> {
            override fun onResponse(call: Call<List<BellScheduleItem>>, response: Response<List<BellScheduleItem>>) {

                if (response.isSuccessful) {
                    response.body()?.let { schedules ->
                        adapter = BellScheduleAdapter(schedules)
                        recyclerView.adapter = adapter
                    }
                }
            }

            override fun onFailure(call: Call<List<BellScheduleItem>>, t: Throwable) {
                // Handle error
            }
        })
    }
}
