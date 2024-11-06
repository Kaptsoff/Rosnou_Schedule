package com.example.rosnouschedule

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rosnouschedule.adapters.RoomAdapter
import com.example.rosnouschedule.data.RoomItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RoomsActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: RoomAdapter
    private lateinit var refreshButton: Button
    private lateinit var backButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rooms)

        recyclerView = findViewById(R.id.recyclerViewRooms)
        refreshButton = findViewById(R.id.refreshButtonRooms)
        backButton = findViewById(R.id.backButtonRooms)

        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = RoomAdapter(emptyList())
        recyclerView.adapter = adapter

        refreshButton.setOnClickListener {
            fetchRooms()
        }

        backButton.setOnClickListener {
            // Возвращаемся на MainActivity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        fetchRooms()
    }

    private fun fetchRooms() {
        RetrofitClient.apiService.getRooms().enqueue(object : Callback<List<RoomItem>> {
            override fun onResponse(call: Call<List<RoomItem>>, response: Response<List<RoomItem>>) {
                if (response.isSuccessful) {
                    response.body()?.let { rooms ->
                        adapter = RoomAdapter(rooms)
                        recyclerView.adapter = adapter
                    }
                }
            }

            override fun onFailure(call: Call<List<RoomItem>>, t: Throwable) {
                // Handle error
            }
        })
    }
}
