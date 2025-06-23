package com.droidnotes.holdingsapp.data.model

data class HoldingsResponse(
    val data: HoldingsData
)

data class HoldingsData(
    val userHolding: List<HoldingsDto>
)