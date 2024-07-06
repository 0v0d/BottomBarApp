package com.example.bottombarapp.ui.search

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.bottombarapp.R
import com.example.bottombarapp.ui.BaseScreen

@Composable
fun SearchScreen(
    modifier: Modifier = Modifier,
) {
    BaseScreen(
        modifier = modifier,
        text = R.string.search,
    )
}