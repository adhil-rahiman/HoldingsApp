package com.droidnotes.holdingsapp.ui.holdings

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.droidnotes.holdingsapp.domain.usecase.PortfolioSummary

@Composable
fun BottomSummaryCard(
    summary: PortfolioSummary,
    expanded: Boolean,
    onToggle: () -> Unit
) {
    val pnlColor = if (summary.totalPNL >= 0) Color(0xFF00B386) else Color(0xFFD32F2F)
    val pnlFormatted = "₹%.2f".format(summary.totalPNL)
    val pnlPercentage = ((summary.totalPNL / summary.investment) * 100).coerceAtLeast(0.0)

    Card(
        Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(horizontal = 8.dp, vertical = 4.dp),
        elevation = CardDefaults.cardElevation()
    ) {
        Column(
            Modifier
                .padding(12.dp)
                .clickable { onToggle() }
        ) {
            if (expanded) {
                Text("Current value*: ₹%.2f".format(summary.currentValue))
                Text("Total investment*: ₹%.2f".format(summary.investment))
                Text("Today's Profit & Loss*: ₹%.2f".format(summary.todayPNL))
                Spacer(Modifier.height(4.dp))
            }
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Profit & Loss*", fontWeight = FontWeight.SemiBold)
                Text("$pnlFormatted (${String.format("%.2f", pnlPercentage)}%)", color = pnlColor)
            }
        }
    }
}
