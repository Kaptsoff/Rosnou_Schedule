package com.example.rosnouschedule

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rosnouschedule.adapters.DisciplinsAdapter
import com.example.rosnouschedule.data.DisciplinsItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DisciplinsActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: DisciplinsAdapter
    private lateinit var refreshButton: Button
    private lateinit var backButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_disciplins)

        recyclerView = findViewById(R.id.recyclerViewDisciplins)
        refreshButton = findViewById(R.id.refreshButtonDisciplins)
        backButton = findViewById(R.id.button_open_main)

        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = DisciplinsAdapter(emptyList())
        recyclerView.adapter = adapter

        refreshButton.setOnClickListener {
            fetchDisciplins()
        }

        backButton.setOnClickListener {
            // Возвращаемся на MainActivity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // Закрываем DisciplinsActivity
        }

        fetchDisciplins()
    }



    private fun fetchDisciplins() {
        RetrofitClient.apiService.getDisciplins().enqueue(object : Callback<List<DisciplinsItem>> {
            override fun onResponse(
                call: Call<List<DisciplinsItem>>,
                response: Response<List<DisciplinsItem>>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let { disciplines ->
                        adapter = DisciplinsAdapter(disciplines)
                        recyclerView.adapter = adapter
                    }
                }
            }

            override fun onFailure(call: Call<List<DisciplinsItem>>, t: Throwable) {
                // Handle error
            }
        })
    }
}
