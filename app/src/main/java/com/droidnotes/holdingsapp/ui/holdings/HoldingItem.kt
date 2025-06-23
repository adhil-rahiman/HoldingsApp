package com.droidnotes.holdingsapp.ui.holdings

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.droidnotes.holdingsapp.domain.model.Holding

@Composable
fun HoldingItemStyled(holding: Holding, pnl: Double) {
    val pnlColor = if (pnl >= 0) Color(0xFF00B386) else Color(0xFFD32F2F)
    val formattedPnl = "₹%.2f".format(pnl)

    Column(Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 8.dp)) {
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(holding.symbol, style = MaterialTheme.typography.bodyLarge)
            Text("LTP: ₹${holding.ltp}", style = MaterialTheme.typography.bodyMedium)
        }

        Spacer(Modifier.height(2.dp))
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text("NET QTY: ${holding.quantity}", color = Color.Gray, style = MaterialTheme.typography.bodySmall)
            Text("P&L: $formattedPnl", color = pnlColor, style = MaterialTheme.typography.bodySmall)
        }

        Divider(Modifier.padding(top = 8.dp))
    }
}
