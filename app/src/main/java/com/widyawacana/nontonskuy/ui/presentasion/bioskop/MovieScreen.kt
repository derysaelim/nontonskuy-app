package com.widyawacana.nontonskuy.ui.presentasion.bioskop

package com.example.cobabuatfilm.Tampilan

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.tooling.preview.Preview
import com.example.cobabuatfilm.Repository.MovieRepository
import com.example.cobabuatfilm.ViewModel.MovieViewModel
import com.example.cobabuatfilm.ViewModel.MovieViewModelFactory
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun MainScreen() {
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
    MainScreen()
}
