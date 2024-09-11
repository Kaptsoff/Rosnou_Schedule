// EducatorsActivity.kt
package com.example.rosnouschedule

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rosnouschedule.adapters.EducatorsAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.example.rosnouschedule.data.EducatorItem

class EducatorsActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: EducatorsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_educators)

        recyclerView = findViewById(R.id.recyclerViewEducators)
        recyclerView.layoutManager = LinearLayoutManager(this)

        fetchEducatorsData()

        val buttonOpenMain = findViewById<Button>(R.id.button_open_main)
        buttonOpenMain.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val buttonRefresh = findViewById<Button>(R.id.button_refresh)
        buttonRefresh.setOnClickListener {
            fetchEducatorsData()  // Обновить данные при нажатии на кнопку
        }
    }

    private fun fetchEducatorsData() {
        val apiService = RetrofitClient.apiService

        val call = apiService.getEducators()
        call.enqueue(object : Callback<List<EducatorItem>> {
            override fun onResponse(call: Call<List<EducatorItem>>, response: Response<List<EducatorItem>>) {
                if (response.isSuccessful) {
                    val educatorsList = response.body()
                    educatorsList?.let {
                        adapter = EducatorsAdapter(it)
                        recyclerView.adapter = adapter
                    }
                }
            }

            override fun onFailure(call: Call<List<EducatorItem>>, t: Throwable) {
                // Handle the failure
            }
        })
    }
}
