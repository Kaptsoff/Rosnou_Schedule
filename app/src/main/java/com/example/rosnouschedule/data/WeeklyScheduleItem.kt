package com.example.rosnouschedule.data

data class WeeklyScheduleItem (
        val schedule_id: Int,
        val schedule_name: String,
        val prepod_id: Int,
        val f: String,
        val i: String,
        val o: String?,
        val schedule_period_id: Int,
        val period_name: String,
        val period_begin: String,
        val period_end: String,
        val disciplins_id: Int,
        val disciplins: String,
        val type_week_id: Int,
        val type_week: String,
        val groups_id: Int,
        val groups: String,
        val room_id: Int,
        val room: String?,
        val campus_id: Int?,
        val campus: String?,
        val week_day_id: Int,
        val week_day: String
    )