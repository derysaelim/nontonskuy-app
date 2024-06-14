package com.widyawacana.nontonskuy.retrofit
import com.widyawacana.nontonskuy.api.MovieApiService


object RetrofitInstance {
    private const val BASE_URL = "https://api.themoviedb.org/3/"

    val api: MovieApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MovieApiService::class.java)
    }
}
