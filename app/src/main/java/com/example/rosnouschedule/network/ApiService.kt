package com.example.rosnouschedule.network

//интерфейс для подключения к API

import com.example.rosnouschedule.data.DisciplinsItem
import com.example.rosnouschedule.data.ScheduleItem
import com.example.rosnouschedule.data.EducatorItem
import com.example.rosnouschedule.data.GroupItem
import com.example.rosnouschedule.data.BellScheduleItem
import com.example.rosnouschedule.data.RoomItem
import com.example.rosnouschedule.data.WeeklyScheduleItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    //забираем расписание на дату
    @GET("v1/schedules/date")
    fun getSchedule(): Call<List<ScheduleItem>>

    //забираем данные о преподавателях
    @GET("v1/educators")
        fun getEducators(): Call<List<EducatorItem>>

    @GET("v1/disciplins")
    fun getDisciplins(): Call<List<DisciplinsItem>>

    @GET("v1/groups")
    fun getGroups(): Call<List<GroupItem>>

    @GET("v1/periods")
    fun getBellSchedules(): Call<List<BellScheduleItem>>

    @GET("v1/rooms")
    fun getRooms(): Call<List<RoomItem>>

    @GET("v1/schedules")
    fun getWeeklySchedule(): Call<List<WeeklyScheduleItem>>

}
