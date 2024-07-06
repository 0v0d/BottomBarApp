package com.example.bottombarapp.ui.home

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.bottombarapp.R
import com.example.bottombarapp.ui.BaseScreen

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
) {
    BaseScreen(
        modifier = modifier,
        text = R.string.home,
    )
}