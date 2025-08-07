package com.example.booktour.data.model
data class Payment(
    var amount: Double = 0.0,
    var method: String = "",
    var status: Boolean = false
)