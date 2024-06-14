package com.widyawacana.nontonskuy.ui.presentasion.bioskop

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.widyawacana.nontonskuy.data.repository.MovieRepository
import com.widyawacana.nontonskuy.viewmodel.MovieViewModel
import com.widyawacana.nontonskuy.viewmodel.MovieViewModelFactory

@Composable
fun MovieScreen() {
    val apiKey = "639f295cf751bb62c7f7b3b16cdb3da1"
    val repository = MovieRepository()
    val viewModel: MovieViewModel = viewModel(
        factory = MovieViewModelFactory(repository)
    )

    LaunchedEffect(Unit) {
        viewModel.fetchNowPlayingMovies(apiKey)
    }

    MovieListScreen(viewModel = viewModel)
}

@Composable
@Preview(showBackground = true)
fun DefaultPreview() {
    MovieScreen()
}
