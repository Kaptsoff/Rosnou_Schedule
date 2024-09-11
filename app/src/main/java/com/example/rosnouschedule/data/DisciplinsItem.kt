package com.example.rosnouschedule.data

data class DisciplinsItem(
    val id: Int,
    val index: String,
    val parent_id: Int?,
    val sprav_dis_id: Int,
    val sprav_kafedra_id: Int,
    val main_plan_id: Int,
    val created_at: Long,
    val created_by: Int,
    val updated_at: Long,
    val updated_by: Int,
    val deleted_at: String?,
    val deleted_by: Int,
    val active: Int,
    val lock: Int
)