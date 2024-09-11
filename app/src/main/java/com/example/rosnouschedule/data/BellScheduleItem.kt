package com.example.rosnouschedule.data

data class BellScheduleItem(
    val id: Int,
    val name: String,
    val begin: String,
    val end: String,
    val created_at: Long,
    val created_by: Int,
    val updated_at: Long,
    val updated_by: Int,
    val deleted_at: Long?,
    val deleted_by: Int,
    val active: Int,
    val lock: Int
)