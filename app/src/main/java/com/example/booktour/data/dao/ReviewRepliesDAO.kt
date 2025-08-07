package com.example.booktour.data.dao

import com.example.booktour.data.model.Reply


interface ReviewRepliesDAO {

    suspend fun themTraLoiDanhGia(tourId: String, reviewId: String, reviewReply: Reply): Boolean

    suspend fun capNhatTraLoiDanhGiaDanhGia(tourId: String, reviewId: String, reply: Reply): Boolean

    suspend fun xoaTraLoiDanhGia(tourId: String, reviewId: String, replyId: String): Boolean

    suspend fun docTatCaRepliesTheoTourId(tourId: String): List<Reply>

    suspend fun docReplyTheoID(tourId: String, reviewId: String, idReply: String): Reply?
}
