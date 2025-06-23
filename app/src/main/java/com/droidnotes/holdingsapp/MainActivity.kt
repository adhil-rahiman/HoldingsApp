package com.droidnotes.holdingsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.droidnotes.holdingsapp.ui.holdings.HoldingsWithTabsScreen
import com.droidnotes.holdingsapp.ui.theme.HoldingsAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HoldingsAppTheme {
                HoldingsWithTabsScreen()
            }
        }
    }
}