package com.example.bottombarapp.ui.star

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.bottombarapp.R
import com.example.bottombarapp.ui.BaseScreen

@Composable
fun StarScreen(
    modifier: Modifier = Modifier,
) {
    BaseScreen(
        modifier = modifier,
        text = R.string.star,
    )
}