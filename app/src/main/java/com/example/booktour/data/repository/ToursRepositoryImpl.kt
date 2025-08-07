package com.example.booktour.data.repository

import com.example.booktour.data.dao.ToursDAO
import com.example.booktour.data.model.Location
import com.example.booktour.data.model.Schedule
import com.example.booktour.data.model.Tour

class ToursRepositoryImpl(private val dao: ToursDAO) {

    suspend fun themLichTrinh(tourId: String, schedule: Schedule): Boolean {
        return dao.themLichTrinh(tourId, schedule)
    }

    suspend fun themTour(tour: Tour): Boolean {
        return dao.themTour(tour)
    }

    suspend fun docTatCaTours(): List<Tour> {
        return dao.docTatCaTours()
    }

    suspend fun capNhatTour(id: String, updates: Map<String, Any>): Boolean {
        return dao.capNhatTour(id, updates)
    }

    suspend fun xoaTour(id: String): Boolean {
        return dao.xoaTour(id)
    }

    suspend fun docTourTheoID(id: String): Tour? {
        return dao.docTourTheoID(id)
    }

    suspend fun layTopTourNhieuNhat(limit: Int): List<Tour> {
        return dao.layTopTourNhieuNhat(limit)
    }

    suspend fun tangLuotDatTour(tourId: String): Boolean {
        return dao.tangLuotDatTour(tourId)
    }

    suspend fun docTourTheoListID(idTours: List<String>): List<Tour> {
        return dao.docTourTheoListID(idTours)
    }

    suspend fun docDangKyDangMoTheoListIDTour(idTours: List<String>): List<Tour> {
        return dao.docDangKyDangMoTheoListIDTour(idTours)
    }

    suspend fun docDangKyDangMoTheoIDTour(idTour: String): List<Tour> {
        return dao.docDangKyDangMoTheoIDTour(idTour)
    }

    suspend fun docDangKyDangMo(): List<Tour> {
        return dao.docDangKyDangMo()
    }

    suspend fun capNhatDiaDiem(tourId: String, location: Location): Boolean {
        return dao.capNhatDiaDiem(tourId, location)
    }
}
