package com.example.quotecomposeapp.data.repository

import com.example.quotecomposeapp.data.models.Quote
import com.example.quotecomposeapp.data.remote.api.QuoteService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class QuoteRepository @Inject constructor(
    private val quoteService: QuoteService
){

    private val _quoteList= MutableStateFlow<List<Quote>>(emptyList())
    val quoteList :StateFlow<List<Quote>> get() = _quoteList
    suspend fun getQuoteList(){
        val response = quoteService.getQuoteList()

        if(response.isSuccessful && response.body() != null){
            _quoteList.emit(response.body()!!)
        }

    }

}