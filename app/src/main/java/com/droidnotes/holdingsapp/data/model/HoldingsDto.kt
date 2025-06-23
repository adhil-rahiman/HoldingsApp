package com.droidnotes.holdingsapp.data.model

data class HoldingsDto(
    val symbol: String,
    val quantity: Int,
    val ltp: Double,
    val avgPrice: Double,
    val close: Double
)