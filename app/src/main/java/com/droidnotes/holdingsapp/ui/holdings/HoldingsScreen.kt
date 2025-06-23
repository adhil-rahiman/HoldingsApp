package com.droidnotes.holdingsapp.ui.holdings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun HoldingsScreen(viewModel: HoldingsViewModel = hiltViewModel()) {
    val state by viewModel.uiState.collectAsState()
    var expanded by remember { mutableStateOf(false) }

    Scaffold(
        topBar = { TopBar() },
        bottomBar = { BottomNavigationBar() }
    ) { innerPadding ->
        Column(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()) {

            LazyColumn(Modifier.weight(1f)) {
                items(state.holdings) { holding ->
                    val pnl = (holding.ltp - holding.avgPrice) * holding.quantity
                    HoldingItemStyled(holding, pnl)
                }
            }

            state.summary?.let {
                BottomSummaryCard(it, expanded = expanded) {
                    expanded = !expanded
                }
            }
        }
    }
}
