package com.example.quotecomposeapp.models

import com.google.gson.annotations.SerializedName

data class Quote(
    @SerializedName("quote")
    val text:String,
    @SerializedName("author")
    val author:String
)