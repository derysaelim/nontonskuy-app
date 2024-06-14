package com.widyawacana.nontonskuy.data.repository


import com.widyawacana.nontonskuy.model.Movie
import com.widyawacana.nontonskuy.retrofit.RetrofitInstance

class MovieRepository {
    suspend fun getNowPlayingMovies(apiKey: String): List<Movie> {
        return RetrofitInstance.api.getNowPlayingMovies(apiKey).results
    }
}