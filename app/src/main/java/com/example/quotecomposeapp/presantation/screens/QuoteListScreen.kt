package com.example.quotecomposeapp.presantation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.quotecomposeapp.R
import com.example.quotecomposeapp.data.models.Quote
import com.example.quotecomposeapp.presantation.viewmodels.QuoteListingViewModel

@Composable
fun QuoteListScreen(onClick: (Quote) -> Unit){
    val viewModel:QuoteListingViewModel = hiltViewModel()
    val data = viewModel.quoteList.collectAsState()
    Column {
        Text(
            text = "Quotes App",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(8.dp, 24.dp)
                .fillMaxWidth(1f),
            style = MaterialTheme.typography.headlineMedium,
            fontFamily = FontFamily(Font(R.font.montserrat_regular))
        )
        QuoteList(data = data.value, onClick = onClick )
    }
}