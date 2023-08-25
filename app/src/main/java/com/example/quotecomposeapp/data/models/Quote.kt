package com.example.quotecomposeapp.data.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Quote(
    @SerializedName("quote")
    val text:String,
    @SerializedName("author")
    val author:String
) : Parcelable