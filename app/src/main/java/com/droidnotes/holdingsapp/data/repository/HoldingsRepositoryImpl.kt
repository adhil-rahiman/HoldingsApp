package com.droidnotes.holdingsapp.data.repository

import com.droidnotes.holdingsapp.data.model.HoldingsDto
import com.droidnotes.holdingsapp.data.remote.HoldingsApi
import com.droidnotes.holdingsapp.domain.model.Holding
import com.droidnotes.holdingsapp.domain.repository.HoldingsRepository
import javax.inject.Inject

class HoldingsRepositoryImpl @Inject constructor(
    private val api: HoldingsApi
) : HoldingsRepository {
    override suspend fun getHoldings(): List<Holding> {
        return api.getHoldings().data.userHolding.map { it.toDomain() }
    }
}

fun HoldingsDto.toDomain(): Holding = Holding(
    symbol = symbol,
    quantity = quantity,
    ltp = ltp,
    avgPrice = avgPrice,
    close = close
)