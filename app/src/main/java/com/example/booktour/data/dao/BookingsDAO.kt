package com.example.booktour.data.dao

import com.example.booktour.data.model.Booking


interface BookingsDAO {

    suspend fun themBooking(booking: Booking): Boolean

    suspend fun docTatCaBookings(): List<Booking>

    suspend fun capNhatBooking(booking: Booking): Boolean

    suspend fun xoaBooking(id: String): Boolean

    suspend fun layDanhSachBookingTheoUser(idUser: String): List<Booking>

    suspend fun layBookingTheoId(id: String): Booking?
}
