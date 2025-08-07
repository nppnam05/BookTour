package com.example.booktour.data.repository

import com.example.booktour.data.dao.ReviewRepliesDAO
import com.example.booktour.data.model.Reply

class ReviewRepliesRepositoryImpl(private val dao: ReviewRepliesDAO) {

    suspend fun docTatCaRepliesTheoTourId(tourId: String): List<Reply> {
        return dao.docTatCaRepliesTheoTourId(tourId)
    }

    suspend fun docReplyTheoID(tourId: String, reviewId: String, idReply: String): Reply? {
        return dao.docReplyTheoID(tourId, reviewId, idReply)
    }

    suspend fun themTraLoiDanhGia(tourId: String, reviewId: String, reply: Reply): Boolean {
        return dao.themTraLoiDanhGia(tourId, reviewId, reply)
    }

    suspend fun capNhatTraLoiDanhGiaDanhGia(tourId: String, reviewId: String, reply: Reply): Boolean {
        return dao.capNhatTraLoiDanhGiaDanhGia(tourId, reviewId, reply)
    }

    suspend fun xoaTraLoiDanhGia(tourId: String, reviewId: String, replyId: String): Boolean {
        return dao.xoaTraLoiDanhGia(tourId, reviewId, replyId)
    }
}
