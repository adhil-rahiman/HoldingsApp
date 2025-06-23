package com.droidnotes.holdingsapp.ui.holdings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.droidnotes.holdingsapp.domain.model.Holding
import com.droidnotes.holdingsapp.domain.repository.HoldingsRepository
import com.droidnotes.holdingsapp.domain.usecase.PortfolioSummary
import com.droidnotes.holdingsapp.domain.usecase.PortfolioUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class HoldingsUiState(
    val holdings: List<Holding> = emptyList(),
    val summary: PortfolioSummary? = null,
    val error: String? = null
)

@HiltViewModel
class HoldingsViewModel @Inject constructor(
    private val repository: HoldingsRepository,
    private val useCase: PortfolioUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(HoldingsUiState())
    val uiState: StateFlow<HoldingsUiState> = _uiState

    init {
        fetchHoldings()
    }

    private fun fetchHoldings() {
        viewModelScope.launch {
            try {
                val data = repository.getHoldings()
                val summary = useCase.calculateSummary(data)
                _uiState.value = HoldingsUiState(data, summary)
            } catch (e: Exception) {
                _uiState.value = HoldingsUiState(error = e.message)
            }
        }
    }
}