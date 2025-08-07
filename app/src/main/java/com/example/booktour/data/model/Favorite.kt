package com.example.booktourdemo.models

data class Favorite(
    var id: String = "",
    var user_id: String = "",
    var tour_id: String = "",
    var created_at: Long = 0L
)
