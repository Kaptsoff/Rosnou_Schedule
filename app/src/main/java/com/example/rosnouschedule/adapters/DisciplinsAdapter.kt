package com.example.rosnouschedule.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rosnouschedule.R
import com.example.rosnouschedule.data.DisciplinsItem

class DisciplinsAdapter(private val disciplines: List<DisciplinsItem>) :
    RecyclerView.Adapter<DisciplinsAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val idTextView: TextView = itemView.findViewById(R.id.textViewId)
        val indexTextView: TextView = itemView.findViewById(R.id.textViewIndex)
        val parentIdTextView: TextView = itemView.findViewById(R.id.textViewParentId)
        val spravDisIdTextView: TextView = itemView.findViewById(R.id.textViewSpravDisId)
        val spravKafedraIdTextView: TextView = itemView.findViewById(R.id.textViewSpravKafedraId)
        val mainPlanIdTextView: TextView = itemView.findViewById(R.id.textViewMainPlanId)
        val createdAtTextView: TextView = itemView.findViewById(R.id.textViewCreatedAt)
        val createdByTextView: TextView = itemView.findViewById(R.id.textViewCreatedBy)
        val updatedAtTextView: TextView = itemView.findViewById(R.id.textViewUpdatedAt)
        val updatedByTextView: TextView = itemView.findViewById(R.id.textViewUpdatedBy)
        val deletedAtTextView: TextView = itemView.findViewById(R.id.textViewDeletedAt)
        val deletedByTextView: TextView = itemView.findViewById(R.id.textViewDeletedBy)
        val activeTextView: TextView = itemView.findViewById(R.id.textViewActive)
        val lockTextView: TextView = itemView.findViewById(R.id.textViewLock)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_disciplins, parent, false)
        return ViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val discipline = disciplines[position]
        holder.idTextView.text = "ID: ${discipline.id}"
        holder.indexTextView.text = "Дисциплина: ${discipline.index}"
        holder.parentIdTextView.text = "Parent ID: ${discipline.parent_id}"
        holder.spravDisIdTextView.text = "Sprav Dis ID: ${discipline.sprav_dis_id}"
        holder.spravKafedraIdTextView.text = "Sprav Kafedra ID: ${discipline.sprav_kafedra_id}"
        holder.mainPlanIdTextView.text = "Main Plan ID: ${discipline.main_plan_id}"
        holder.createdAtTextView.text = "Created At: ${discipline.created_at}"
        holder.createdByTextView.text = "Created By: ${discipline.created_by}"
        holder.updatedAtTextView.text = "Updated At: ${discipline.updated_at}"
        holder.updatedByTextView.text = "Updated By: ${discipline.updated_by}"
        holder.deletedAtTextView.text = "Deleted At: ${discipline.deleted_at}"
        holder.deletedByTextView.text = "Deleted By: ${discipline.deleted_by}"
        holder.activeTextView.text = "Active: ${discipline.active}"
        holder.lockTextView.text = "Lock: ${discipline.lock}"
    }

    override fun getItemCount(): Int {
        return disciplines.size
    }
}
