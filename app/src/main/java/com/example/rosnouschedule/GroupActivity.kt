package com.example.rosnouschedule

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rosnouschedule.adapters.GroupAdapter
import com.example.rosnouschedule.data.GroupItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GroupActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: GroupAdapter
    private lateinit var refreshButton: Button
    private lateinit var backButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_groups)

        recyclerView = findViewById(R.id.recyclerViewGroups)
        refreshButton = findViewById(R.id.refreshButtonGroups)
        backButton = findViewById(R.id.backButtonGroups)

        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = GroupAdapter(emptyList())
        recyclerView.adapter = adapter

        refreshButton.setOnClickListener {
            fetchGroups()
        }

        backButton.setOnClickListener {
            // Возвращаемся на MainActivity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // Закрываем GroupActivity
        }

        fetchGroups()
    }

    private fun fetchGroups() {
        RetrofitClient.apiService.getGroups().enqueue(object : Callback<List<GroupItem>> {
            override fun onResponse(call: Call<List<GroupItem>>, response: Response<List<GroupItem>>) {
                if (response.isSuccessful) {
                    response.body()?.let { groups ->
                        adapter = GroupAdapter(groups)
                        recyclerView.adapter = adapter
                    }
                }
            }

            override fun onFailure(call: Call<List<GroupItem>>, t: Throwable) {
                // Handle error
            }
        })
    }
}
