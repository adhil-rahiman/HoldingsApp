package com.droidnotes.holdingsapp.data.remote

import com.droidnotes.holdingsapp.data.model.HoldingsDto
import com.droidnotes.holdingsapp.data.model.HoldingsResponse
import retrofit2.http.GET

interface HoldingsApi {
    @GET("/")
    suspend fun getHoldings(): HoldingsResponse
}