package com.droidnotes.holdingsapp.ui.holdings

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Sort
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    TopAppBar(
        title = {
            Text("Portfolio", color = Color.White)
        },
        navigationIcon = {
            Icon(Icons.Default.AccountCircle, contentDescription = "Profile", tint = Color.White, modifier = Modifier.padding(start = 8.dp))
        },
        actions = {
            Icon(
                imageVector = Icons.Default.Sort,
                contentDescription = "Filter",
                tint = Color.White,
                modifier = Modifier
            )
            Spacer(Modifier.width(12.dp))
            Icon(Icons.Default.Search, contentDescription = "Search", tint = Color.White)
            Spacer(Modifier.width(12.dp))
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(0xFF003366) // navy blue
        )
    )
}
