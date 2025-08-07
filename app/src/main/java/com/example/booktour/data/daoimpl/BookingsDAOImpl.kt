package com.example.booktour.data.daoimpl

import android.util.Log
import com.example.booktour.data.dao.BookingsDAO
import com.example.booktour.data.model.Booking
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.tasks.await


class BookingsDAOImpl(private val db: FirebaseFirestore) : BookingsDAO {

    private val collection = db.collection("bookings")

    override suspend fun themBooking(booking: Booking): Boolean {
        return try {
            // Tạo tài liệu mới với ID tự sinh
            val documentRef = collection.document()
            // Cập nhật ID của booking với ID tự sinh
            val updatedBooking = booking.copy(id = documentRef.id)
            // Lưu booking với ID tự sinh vào Firestore
            documentRef.set(updatedBooking).await()
            true
        } catch (e: Exception) {
            false
        }
    }


    override suspend fun docTatCaBookings(): List<Booking> = coroutineScope {
        try {
            val snapshot = collection
                .orderBy("created_at", Query.Direction.DESCENDING)
                .get()
                .await()

            // Nếu cần fetch thêm các subcollection sau này thì gói mỗi doc vào async như thế này
            val tasks = snapshot.map { doc ->
                async {
                    try {
                        doc.toObject(Booking::class.java)?.copy(id = doc.id)
                    } catch (e: Exception) {
                        Log.e("BookingsDAO", "Lỗi khi ánh xạ Booking: ${e.message}")
                        null
                    }
                }
            }

            tasks.awaitAll().filterNotNull()
        } catch (e: Exception) {
            Log.e("BookingsDAO", "Lỗi khi đọc tất cả bookings: ${e.message}")
            emptyList()
        }
    }



    override suspend fun layDanhSachBookingTheoUser(userId: String): List<Booking> = coroutineScope {
        try {
            val snapshot = collection
                .whereEqualTo("user_id", userId)
                .orderBy("created_at", Query.Direction.DESCENDING)
                .get()
                .await()

            val tasks = snapshot.map { doc ->
                async {
                    try {
                        doc.toObject(Booking::class.java)?.copy(id = doc.id)
                    } catch (e: Exception) {
                        Log.e("BookingsDAO", "Lỗi khi ánh xạ Booking theo user: ${e.message}")
                        null
                    }
                }
            }

            tasks.awaitAll().filterNotNull()
        } catch (e: Exception) {
            Log.d("BookingsDAO", "Lỗi khi lấy danh sách booking theo user: $e")
            emptyList()
        }
    }


    override suspend fun layBookingTheoId(id: String): Booking? {
        return try {
            val snapshot = collection.document(id).get().await()
            snapshot.toObject(Booking::class.java)
        } catch (e: Exception) {
            null
        }
    }

    override suspend fun capNhatBooking(booking: Booking): Boolean {
        return try {
            collection.document(booking.id).set(booking).await()
            true
        } catch (e: Exception) {
            false
        }
    }

    override suspend fun xoaBooking(id: String): Boolean {
        return try {
            collection.document(id).delete().await()
            true
        } catch (e: Exception) {
            false
        }
    }

}
