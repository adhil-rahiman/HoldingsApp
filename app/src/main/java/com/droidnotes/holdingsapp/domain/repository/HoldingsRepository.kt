package com.droidnotes.holdingsapp.domain.repository

import com.droidnotes.holdingsapp.domain.model.Holding

interface HoldingsRepository {
    suspend fun getHoldings(): List<Holding>
}