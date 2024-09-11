package com.example.rosnouschedule

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rosnouschedule.adapters.BellScheduleAdapter
import com.example.rosnouschedule.data.BellScheduleItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BellScheduleActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: BellScheduleAdapter
    private lateinit var refreshButton: Button
    private lateinit var backButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bell_schedule)

        recyclerView = findViewById(R.id.recyclerViewBellSchedule)
        refreshButton = findViewById(R.id.refreshButtonBellSchedule)
        backButton = findViewById(R.id.backButtonBellSchedule)

        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = BellScheduleAdapter(emptyList())
        recyclerView.adapter = adapter

        refreshButton.setOnClickListener {
            fetchBellSchedules()
        }

        backButton.setOnClickListener {
            // Возвращаемся на MainActivity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

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
