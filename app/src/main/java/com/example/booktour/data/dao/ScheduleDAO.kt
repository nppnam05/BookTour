package com.example.booktour.data.dao

import com.example.booktour.data.model.Schedule


interface ScheduleDAO {

    suspend fun themLichTrinh(tourId: String, schedule: Schedule): Boolean

    suspend fun docTatCaLichTrinh(tourId: String): List<Schedule>

    suspend fun docTatCaLichTrinhToanCuc(): List<Schedule>

    suspend fun capNhatLichTrinh(tourId: String, scheduleId: String, schedule: Schedule): Boolean

    suspend fun xoaLichTrinh(tourId: String, scheduleId: String): Boolean

    suspend fun docLichTrinhTheoID(tourId: String, scheduleId: String): Schedule?

    suspend fun capNhatGiaiDoanDangKy(tourId: String, scheduleId: String,): Boolean

    suspend fun docSchedulesTheoIds(idTours: List<String>, idSchedules: List<String>): List<Schedule>
}
