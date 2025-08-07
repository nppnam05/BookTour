package com.example.booktour.data.repository

import com.example.booktour.data.dao.ScheduleDAO
import com.example.booktour.data.model.Schedule

class ScheduleRepositoryImpl(private val dao: ScheduleDAO) {

    suspend fun themLichTrinh(tourId: String, schedule: Schedule): Boolean {
        return dao.themLichTrinh(tourId, schedule)
    }

    suspend fun docSchedulesTheoIds(idTours: List<String>, idSchedules: List<String>): List<Schedule> {
        return dao.docSchedulesTheoIds(idTours, idSchedules)
    }

    suspend fun docTatCaLichTrinh(tourId: String): List<Schedule> {
        return dao.docTatCaLichTrinh(tourId)
    }

    suspend fun docTatCaLichTrinhToanCuc(): List<Schedule> {
        return dao.docTatCaLichTrinhToanCuc()
    }

    suspend fun capNhatLichTrinh(tourId: String, scheduleId: String, schedule: Schedule): Boolean {
        return dao.capNhatLichTrinh(tourId, scheduleId, schedule)
    }

    suspend fun xoaLichTrinh(tourId: String, scheduleId: String): Boolean {
        return dao.xoaLichTrinh(tourId, scheduleId)
    }

    suspend fun docLichTrinhTheoID(tourId: String, scheduleId: String): Schedule? {
        return dao.docLichTrinhTheoID(tourId, scheduleId)
    }

    suspend fun capNhatGiaiDoanDangKy(tourId: String, scheduleId: String): Boolean {
        return dao.capNhatGiaiDoanDangKy(tourId, scheduleId)
    }
}
