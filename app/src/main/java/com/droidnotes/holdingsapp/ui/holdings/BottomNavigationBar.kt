package com.droidnotes.holdingsapp.ui.holdings

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CurrencyRupee
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Money
import androidx.compose.material.icons.filled.WorkOutline
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun BottomNavigationBar(selectedIndex: Int = 2) {
    val items = listOf("Watchlist", "Orders", "Portfolio", "Funds", "Invest")
    val icons = listOf(Icons.Default.List, Icons.Default.History, Icons.Default.WorkOutline, Icons.Default.CurrencyRupee, Icons.Default.Money)

    NavigationBar {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = index == selectedIndex,
                onClick = { /* TODO */ },
                icon = { Icon(icons[index], contentDescription = item) },
                label = { Text(item) }
            )
        }
    }
}
