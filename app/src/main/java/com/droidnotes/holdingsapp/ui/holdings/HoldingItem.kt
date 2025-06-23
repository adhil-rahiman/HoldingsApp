package com.droidnotes.holdingsapp.ui.holdings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.droidnotes.holdingsapp.domain.model.Holding

@Composable
fun HoldingItemStyled(holding: Holding, pnl: Double) {
    val pnlColor = if (pnl >= 0) Color(0xFF00B386) else Color(0xFFD32F2F)
    val formattedPnl = "₹%.2f".format(pnl)

    Column(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp)
    ) {
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = holding.symbol,
                style = MaterialTheme.typography.bodyLarge.copy(fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
            )
            Text(
                text = "₹${holding.ltp}",
                style = MaterialTheme.typography.bodyLarge.copy(fontSize = 16.sp, fontWeight = FontWeight.Medium)
            )
        }

        Spacer(Modifier.height(4.dp))

        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "NET QTY: ${holding.quantity}",
                style = MaterialTheme.typography.bodySmall.copy(fontSize = 12.sp),
                color = Color.Gray
            )
            Text(
                text = "P&L: $formattedPnl",
                style = MaterialTheme.typography.bodySmall.copy(fontSize = 12.sp),
                color = pnlColor
            )
        }

        Spacer(Modifier.height(8.dp))
        HorizontalDivider(color = Color.LightGray, thickness = 0.5.dp)
    }
}

