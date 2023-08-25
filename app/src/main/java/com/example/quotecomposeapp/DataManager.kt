package com.example.quotecomposeapp

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.example.quotecomposeapp.data.models.Quote
import com.example.quotecomposeapp.presantation.Pages
import com.google.gson.Gson

object DataManager {

    var currentPage = mutableStateOf(Pages.LISTING)
    var data = emptyArray<Quote>()
    val isDataLoaded = mutableStateOf(false)
    var currentQuote: Quote?= null

    fun loadAssetsFromFile(context: Context){
        val inputStream = context.assets.open("quotes.json")
        val size: Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer,Charsets.UTF_8)
        val gson = Gson()
        data = gson.fromJson(json,Array<Quote>::class.java)
        isDataLoaded.value = true
    }

    fun switchPages(quote: Quote?) {
        if(currentPage.value == Pages.LISTING){
            currentQuote = quote
            currentPage.value = Pages.DETAILS
        } else{
            currentPage.value = Pages.LISTING
        }
    }
}