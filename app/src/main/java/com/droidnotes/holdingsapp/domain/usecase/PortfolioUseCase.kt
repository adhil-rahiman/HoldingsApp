package com.droidnotes.holdingsapp.domain.usecase

import com.droidnotes.holdingsapp.domain.model.Holding

data class PortfolioSummary(
    val currentValue: Double,
    val investment: Double,
    val totalPNL: Double,
    val todayPNL: Double
)

class PortfolioUseCase {
    fun calculateSummary(holdings: List<Holding>): PortfolioSummary {
        val current = holdings.sumOf { it.ltp * it.quantity }
        val invest = holdings.sumOf { it.avgPrice * it.quantity }
        val today = holdings.sumOf { (it.close - it.ltp) * it.quantity }
        return PortfolioSummary(current, invest, current - invest, today)
    }
}