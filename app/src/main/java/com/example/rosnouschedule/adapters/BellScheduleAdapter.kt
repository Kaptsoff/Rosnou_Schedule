package com.example.rosnouschedule.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rosnouschedule.R
import com.example.rosnouschedule.data.BellScheduleItem

class BellScheduleAdapter(private val schedules: List<BellScheduleItem>) : RecyclerView.Adapter<BellScheduleAdapter.BellScheduleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BellScheduleViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_bell_schedule, parent, false)
        return BellScheduleViewHolder(view)
    }

    override fun onBindViewHolder(holder: BellScheduleViewHolder, position: Int) {
        val schedule = schedules[position]
        holder.bind(schedule)
    }

    override fun getItemCount(): Int = schedules.size

    class BellScheduleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.bellNameTextView)
        private val beginTextView: TextView = itemView.findViewById(R.id.bellBeginTextView)
        private val endTextView: TextView = itemView.findViewById(R.id.bellEndTextView)

        fun bind(schedule: BellScheduleItem) {
            nameTextView.text = schedule.name
            beginTextView.text = schedule.begin
            endTextView.text = schedule.end
        }
    }
}
