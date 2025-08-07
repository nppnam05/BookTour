package com.example.booktour.data.dao
import com.example.booktour.data.model.Payment


interface PaymentsDAO {

    suspend fun themThanhToan(payment: Payment): Boolean

    suspend fun docTatCaThanhToan(): List<Payment>

    suspend fun capNhatThanhToan(payment: Payment): Boolean

    suspend fun xoaThanhToan(id: String): Boolean
}
