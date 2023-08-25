package com.example.quotecomposeapp.data.remote.api

import com.example.quotecomposeapp.data.models.Quote
import retrofit2.Response
import retrofit2.http.GET

interface QuoteService {

    @GET("/v3/b/64e89b44b89b1e2299d5dd09?meta=false")
    suspend fun getQuoteList() : Response<List<Quote>>

}