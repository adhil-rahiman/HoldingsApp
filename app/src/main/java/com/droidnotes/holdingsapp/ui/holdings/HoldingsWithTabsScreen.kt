package com.droidnotes.holdingsapp.ui.holdings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun HoldingsWithTabsScreen(viewModel: HoldingsViewModel = hiltViewModel()) {
    var selectedTabIndex by remember { mutableIntStateOf(1) } // default to Holdings

    Scaffold(
        topBar = { TopBar() },
        bottomBar = { BottomNavigationBar() }
    ) { innerPadding ->
        Column(Modifier.padding(innerPadding)) {
            HoldingsTabRow(selectedTabIndex) { selectedTabIndex = it }

            when (selectedTabIndex) {
                0 -> Text("Positions (Coming soon)", modifier = Modifier.padding(16.dp))
                1 -> HoldingsContent(viewModel)
            }
        }
    }
}

@Composable
fun HoldingsTabRow(selectedTabIndex: Int, onTabSelected: (Int) -> Unit) {
    val titles = listOf("Positions", "Holdings")
    TabRow(
        selectedTabIndex = selectedTabIndex,
        containerColor = Color.White,
        contentColor = MaterialTheme.colorScheme.primary
    ) {
        titles.forEachIndexed { index, title ->
            Tab(
                selected = selectedTabIndex == index,
                onClick = { onTabSelected(index) },
                text = {
                    Text(
                        title,
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = if (selectedTabIndex == index) FontWeight.Bold else FontWeight.Normal
                    )
                }
            )
        }
    }
}

@Composable
fun HoldingsContent(viewModel: HoldingsViewModel) {
    val state by viewModel.uiState.collectAsState()
    var expanded by remember { mutableStateOf(false) }

    Column(modifier = Modifier.fillMaxSize()) {
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
