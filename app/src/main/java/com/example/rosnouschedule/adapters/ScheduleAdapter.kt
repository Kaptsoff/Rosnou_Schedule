package com.example.rosnouschedule.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rosnouschedule.R
import com.example.rosnouschedule.data.ScheduleItem
import java.text.SimpleDateFormat
import java.util.*

class ScheduleAdapter(private val scheduleList: List<ScheduleItem>) : RecyclerView.Adapter<ScheduleAdapter.ScheduleViewHolder>() {

    class ScheduleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewScheduleName: TextView = itemView.findViewById(R.id.textViewScheduleName)
        val textViewDate: TextView = itemView.findViewById(R.id.textViewDate)
        val textViewPeriodName: TextView = itemView.findViewById(R.id.textViewPeriodName)
        val textViewPeriodBegin: TextView = itemView.findViewById(R.id.textViewPeriodBegin)
        val textViewPeriodEnd: TextView = itemView.findViewById(R.id.textViewPeriodEnd)
        val textViewGroups: TextView = itemView.findViewById(R.id.textViewGroups)
        val textViewDisciplins: TextView = itemView.findViewById(R.id.textViewDisciplins)
        val textViewPrepod: TextView = itemView.findViewById(R.id.textViewPrepod)
        val textViewRoom: TextView = itemView.findViewById(R.id.textViewRoom)
        val textViewCampus: TextView = itemView.findViewById(R.id.textViewCampus)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_schedule, parent, false)
        return ScheduleViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return scheduleList.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ScheduleViewHolder, position: Int) {
        val scheduleItem = scheduleList[position]

        // Форматирование даты
        val date = Date(scheduleItem.date * 1000L)  // умножаем на 1000 для конвертации секунд в миллисекунды
        val format = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
        val formattedDate = format.format(date)

        holder.textViewScheduleName.text = scheduleItem.schedule_name
        holder.textViewDate.text = formattedDate  // Отформатированная дата
        holder.textViewPeriodName.text = scheduleItem.period_name
        holder.textViewPeriodBegin.text = scheduleItem.period_begin
        holder.textViewPeriodEnd.text = scheduleItem.period_end
        holder.textViewGroups.text = scheduleItem.groups
        holder.textViewDisciplins.text = scheduleItem.disciplins
        holder.textViewPrepod.text = "${scheduleItem.f} ${scheduleItem.i} ${scheduleItem.o ?: ""}".trim()
        holder.textViewRoom.text = scheduleItem.room
        holder.textViewCampus.text = scheduleItem.campus ?: "N/A"
    }
}

