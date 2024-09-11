package com.example.rosnouschedule

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rosnouschedule.adapters.ScheduleAdapter
import com.example.rosnouschedule.data.ScheduleItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var scheduleAdapter: ScheduleAdapter
    private lateinit var updateButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        updateButton = findViewById(R.id.updateButton)
        updateButton.setOnClickListener {
            fetchSchedule()  // Обновляем данные при нажатии кнопки
        }

        val buttonOpenEducators = findViewById<Button>(R.id.button_open_educators)
        buttonOpenEducators.setOnClickListener {
            val intent = Intent(this, EducatorsActivity::class.java)
            startActivity(intent)
        }

        val buttonOpenDisciplins = findViewById<Button>(R.id.button_open_disciplins)
        buttonOpenDisciplins.setOnClickListener {
            val intent = Intent(this, DisciplinsActivity::class.java)
            startActivity(intent)
        }

        val groupsButton = findViewById<Button>(R.id.groupsButton)
        groupsButton.setOnClickListener {
            val intent = Intent(this, GroupActivity::class.java)
            startActivity(intent)
        }

        val bellScheduleButton = findViewById<Button>(R.id.bellScheduleButton)
        bellScheduleButton.setOnClickListener {
            val intent = Intent(this, BellScheduleActivity::class.java)
            startActivity(intent)
        }

        val roomsButton = findViewById<Button>(R.id.roomsButton)
        roomsButton.setOnClickListener {
            val intent = Intent(this, RoomsActivity::class.java)
            startActivity(intent)
        }

        fetchSchedule()
    }

    private fun fetchSchedule() {
        val call = RetrofitClient.apiService.getSchedule()

        call.enqueue(object : Callback<List<ScheduleItem>> {
            override fun onResponse(
                call: Call<List<ScheduleItem>>,
                response: Response<List<ScheduleItem>>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let { scheduleList ->
                        scheduleAdapter = ScheduleAdapter(scheduleList)
                        recyclerView.adapter = scheduleAdapter
                    }
                } else {
                    Toast.makeText(this@MainActivity, "Failed to load data: ${response.code()} ${response.message()}", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<ScheduleItem>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
