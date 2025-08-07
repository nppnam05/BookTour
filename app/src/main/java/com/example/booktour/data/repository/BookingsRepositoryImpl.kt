package com.example.booktour.data.repository

import com.example.booktour.data.dao.BookingsDAO
import com.example.booktour.data.model.Booking

class BookingsRepositoryImpl(private val dao: BookingsDAO) {

    suspend fun themBooking(booking: Booking): Boolean {
        return dao.themBooking(booking)
    }

    suspend fun docTatCaBookings(): List<Booking> {
        return dao.docTatCaBookings()
    }

    suspend fun layDanhSachBookingTheoUser(userId: String): List<Booking> {
        return dao.layDanhSachBookingTheoUser(userId)
    }

    suspend fun layBookingTheoId(id: String): Booking? {
        return dao.layBookingTheoId(id)
    }

    suspend fun capNhatBooking(booking: Booking): Boolean {
        return dao.capNhatBooking(booking)
    }

    suspend fun xoaBooking(id: String): Boolean {
        return dao.xoaBooking(id)
    }
}
