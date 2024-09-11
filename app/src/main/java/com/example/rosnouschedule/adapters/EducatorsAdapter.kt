// EducatorsAdapter.kt
package com.example.rosnouschedule.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rosnouschedule.R
import com.example.rosnouschedule.data.EducatorItem

class EducatorsAdapter(private val educatorsList: List<EducatorItem>) :
    RecyclerView.Adapter<EducatorsAdapter.EducatorsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EducatorsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_educator, parent, false)
        return EducatorsViewHolder(view)
    }

    override fun onBindViewHolder(holder: EducatorsViewHolder, position: Int) {
        val educator = educatorsList[position]
        holder.textViewName.text = "${educator.f} ${educator.i} ${educator.o ?: ""}".trim()
        holder.textViewBirthday.text = educator.birthday
        holder.textViewEmail.text = educator.email ?: "N/A"
        holder.textViewPhone.text = educator.phone ?: "N/A"
        holder.textViewRole.text = educator.role ?: "N/A"
    }

    override fun getItemCount(): Int {
        return educatorsList.size
    }

    class EducatorsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewName: TextView = itemView.findViewById(R.id.textViewName)
        val textViewBirthday: TextView = itemView.findViewById(R.id.textViewBirthday)
        val textViewEmail: TextView = itemView.findViewById(R.id.textViewEmail)
        val textViewPhone: TextView = itemView.findViewById(R.id.textViewPhone)
        val textViewRole: TextView = itemView.findViewById(R.id.textViewRole)
    }
}
