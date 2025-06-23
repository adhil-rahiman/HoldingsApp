package com.droidnotes.holdingsapp.ui.holdings

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.droidnotes.holdingsapp.domain.usecase.PortfolioSummary

@Composable
fun BottomSummaryCard(
    summary: PortfolioSummary,
    expanded: Boolean,
    onToggle: () -> Unit
) {
    val pnlColor = if (summary.totalPNL >= 0) Color(0xFF00B386) else Color(0xFFD32F2F)
    val pnlFormatted = "₹%.2f".format(summary.totalPNL)
    val pnlPercent = (summary.totalPNL / summary.investment * 100).coerceAtLeast(0.0)
    val formattedPercent = "%.2f".format(pnlPercent)

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 6.dp)
            .clickable { onToggle() }
            .animateContentSize(),
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            if (expanded) {
                InfoRow(label = "Current value*", value = "₹%.2f".format(summary.currentValue))
                Spacer(Modifier.height(4.dp))
                InfoRow(label = "Total investment*", value = "₹%.2f".format(summary.investment))
                Spacer(Modifier.height(4.dp))
                InfoRow(label = "Today's Profit & Loss*", value = "₹%.2f".format(summary.todayPNL))
                Spacer(Modifier.height(8.dp))
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "Profit & Loss*",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color(0xFF003366)
                    )
                    Spacer(Modifier.width(4.dp))
                    Icon(
                        imageVector = if (expanded) Icons.Default.KeyboardArrowDown else Icons.Default.KeyboardArrowUp,
                        contentDescription = "Toggle Summary",
                        tint = Color.Gray
                    )
                }

                Text(
                    text = "$pnlFormatted ($formattedPercent%)",
                    color = pnlColor,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}


@Composable
fun InfoRow(label: String, value: String) {
    Row(
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(label, fontSize = 12.sp, color = Color.Gray)
        Text(value, fontSize = 12.sp, color = Color.Black)
    }
}