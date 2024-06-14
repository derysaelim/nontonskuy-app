package com.widyawacana.nontonskuy.api
import retrofit2.http.Query
import com.widyawacana.nontonskuy.model.MovieResponse
import retrofit2.http.GET

interface MovieApiService {
    @GET("movie/now_playing")
    suspend fun getNowPlayingMovies(
        @Query("api_key") apiKey: String
    ): MovieResponse
}