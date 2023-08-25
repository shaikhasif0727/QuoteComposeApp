package com.example.quotecomposeapp.presantation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quotecomposeapp.data.models.Quote
import com.example.quotecomposeapp.data.repository.QuoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuoteListingViewModel @Inject constructor(
    private val quoteRepository: QuoteRepository
) : ViewModel() {

    val quoteList:StateFlow<List<Quote>>
        get() = quoteRepository.quoteList

    init {
        fetchQuoteList()
    }

    private fun fetchQuoteList(){
        viewModelScope.launch {
            quoteRepository.getQuoteList()
        }
    }

}