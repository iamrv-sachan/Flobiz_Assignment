package com.rajdroid.flobizassignment.entity

data class News(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)