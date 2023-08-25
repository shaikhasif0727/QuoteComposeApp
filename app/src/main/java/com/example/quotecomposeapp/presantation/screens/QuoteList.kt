package com.example.quotecomposeapp.presantation.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.quotecomposeapp.data.models.Quote


@Composable
fun QuoteList(data: List<Quote>, onClick: (Quote) -> Unit){

    LazyColumn(content = {
        items(data){
            QuoteListItem(quote = it, onClick = onClick)
        }
    })

}