package com.example.rosnouschedule.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rosnouschedule.R
import com.example.rosnouschedule.data.Room

class RoomAdapter(private val rooms: List<Room>) : RecyclerView.Adapter<RoomAdapter.RoomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_room, parent, false)
        return RoomViewHolder(view)
    }

    override fun onBindViewHolder(holder: RoomViewHolder, position: Int) {
        val room = rooms[position]
        holder.bind(room)
    }

    override fun getItemCount(): Int = rooms.size

    class RoomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.roomNameTextView)
        private val levelTextView: TextView = itemView.findViewById(R.id.roomLevelTextView)

        fun bind(room: Room) {
            nameTextView.text = room.name
            levelTextView.text = room.level.toString()
        }
    }
}
