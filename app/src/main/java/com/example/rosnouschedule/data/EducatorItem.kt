package com.example.rosnouschedule.data

//класс, хранящий все items о преподавателях

data class EducatorItem(
    val id: Int,
    val f: String,
    val i: String,
    val o: String?,
    val birthday: String,
    val email: String?,
    val phone: String?,
    val role: String?
)
