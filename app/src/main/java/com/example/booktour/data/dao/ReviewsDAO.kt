package com.example.booktour.data.dao
import com.example.booktour.data.model.Review


interface ReviewsDAO {
    suspend fun themReview(tourid: String,review: Review): Boolean

    suspend fun docTatCaReviewsTheoTourID(idTour: String): List<Review>

    suspend fun docReviewTheoId(idTour: String, idReview: String): Review?

    suspend fun capNhatReview(tourId: String, review: Review): Boolean

    suspend fun xoaReview(tourId: String, reviewId: String): Boolean
}
