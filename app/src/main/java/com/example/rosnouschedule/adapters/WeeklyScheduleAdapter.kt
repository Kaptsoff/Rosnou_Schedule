package com.example.rosnouschedule.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rosnouschedule.R
import com.example.rosnouschedule.data.WeeklyScheduleItem

class WeeklyScheduleAdapter(private var scheduleList: List<WeeklyScheduleItem>) :
    RecyclerView.Adapter<WeeklyScheduleAdapter.ScheduleViewHolder>() {

    class ScheduleViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val periodTime: TextView = view.findViewById(R.id.periodTime)
        val discipline: TextView = view.findViewById(R.id.discipline)
        val teacher: TextView = view.findViewById(R.id.teacher)
        val room: TextView = view.findViewById(R.id.roomItem)
        val typeWeek: TextView = view.findViewById(R.id.typeWeek)
        val weekDay: TextView = view.findViewById(R.id.weekDay)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_weekly_schedule, parent, false)
        return ScheduleViewHolder(view)
    }

    override fun onBindViewHolder(holder: ScheduleViewHolder, position: Int) {
        val schedule = scheduleList[position]
        holder.periodTime.text = "${schedule.period_begin} - ${schedule.period_end}"
        holder.discipline.text = schedule.disciplins
        holder.teacher.text = "${schedule.f} ${schedule.i}. ${schedule.o ?: ""}"
        holder.room.text = schedule.room ?: "—"
        holder.typeWeek.text = schedule.type_week
        holder.weekDay.text = schedule.week_day
    }

    override fun getItemCount() = scheduleList.size

    fun updateData(newScheduleList: List<WeeklyScheduleItem>) {
        scheduleList = newScheduleList
        notifyDataSetChanged()
    }
}