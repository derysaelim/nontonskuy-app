package com.widyawacana.nontonskuy.model


data class MovieResponse(
        val results: List<Movie>
)
data class Movie(
        val title: String,
        val release_date: String,
        val poster_path: String
)