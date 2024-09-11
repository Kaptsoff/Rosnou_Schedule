package com.example.rosnouschedule.data

//класс, хранящий все items расписания

data class ScheduleItem(
    val schedule_id: Int,
    val schedule_name: String,
    val schedule_main: Int,
    val date: Long,
    val schedule_period_id: Int,
    val period_name: String,
    val period_begin: String,
    val period_end: String,
    val groups_id: Int,
    val groups: String,
    val disciplins_id: Int,
    val disciplins: String,
    val prepod_id: Int,
    val f: String,
    val i: String,
    val o: String?,
    val room_id: Int,
    val room: String,
    val campus_id: Int?,
    val campus: String?
)