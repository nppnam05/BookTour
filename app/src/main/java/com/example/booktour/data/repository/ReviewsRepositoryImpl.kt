package com.example.booktour.data.repository

import com.example.booktour.data.dao.ReviewsDAO
import com.example.booktour.data.model.Review

class ReviewsRepositoryImpl(private val dao: ReviewsDAO) {

    suspend fun docTatCaReviewsTheoTourID(idTour: String): List<Review> {
        return dao.docTatCaReviewsTheoTourID(idTour)
    }

    suspend fun docReviewTheoId(idTour: String, idReview: String): Review? {
        return dao.docReviewTheoId(idTour, idReview)
    }

    suspend fun themReview(tourId: String, review: Review): Boolean {
        return dao.themReview(tourId, review)
    }

    suspend fun capNhatReview(tourId: String, review: Review): Boolean {
        return dao.capNhatReview(tourId, review)
    }

    suspend fun xoaReview(tourId: String, reviewId: String): Boolean {
        return dao.xoaReview(tourId, reviewId)
    }
}
