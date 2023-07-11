package com.example.androiddemo.network.data

data class MovieList(
    val Response: String,
    val Search: List<Search>,
    val totalResults: String
)