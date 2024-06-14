package com.widyawacana.nontonskuy.ui.presentasion.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth
import com.widyawacana.nontonskuy.R
import com.widyawacana.nontonskuy.data.local.datastore.DataStore
import com.widyawacana.nontonskuy.ui.presentasion.bioskop.MovieCard
import com.widyawacana.nontonskuy.viewmodel.MovieViewModel

@Composable
fun HomeScreen(modifier: Modifier = Modifier, navController: NavController) {
    val currentUser = FirebaseAuth.getInstance().currentUser?.email?.substringBefore("@") ?: "N/A"
//    val movies by viewModel.movies.observeAsState(emptyList())
    val context = LocalContext.current
    val corountineScope = rememberCoroutineScope()

    val dataStore = DataStore(context)

    LazyColumn(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxHeight()
    ) {
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .background(
                        color = Color.Black,
                        shape = RoundedCornerShape(bottomStart = 32.dp, bottomEnd = 32.dp)
                    ),
                contentAlignment = Alignment.Center,
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 24.dp, end = 24.dp)
                ) {
                    val borderWidth = 3.dp
                    Image(
                        painter = painterResource(id = R.drawable.img_profile),
                        contentDescription = "Profile Image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(48.dp)
                            .border(
                                BorderStroke(borderWidth, Color.White), CircleShape
                            )
                            .padding(borderWidth)
                            .clip(
                                CircleShape
                            )
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Column(
                        modifier = Modifier,
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.Start
                    ) {
                        Text(
                            text = "Halo, selamat datang!",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Normal,
                            color = Color.White
                        )
                        Text(
                            text = currentUser,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                }
            }
        }

        item {
            Row(modifier = Modifier
                .horizontalScroll(rememberScrollState())
                .padding(start = 24.dp, top = 20.dp, end = 20.dp)) {
                SliderHeader()
                Spacer(modifier = Modifier.width(12.dp))
                SliderHeader()
            }
        }

        item {
            Row(modifier = Modifier
                .padding(start = 24.dp, top = 20.dp, end = 24.dp, bottom = 12.dp)
                .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                Text("Rekomendasi Film", fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
                Text("See all", fontSize = 12.sp, fontWeight = FontWeight.Normal, color = Color(0xFF756AB6))
            }
        }

//        items(movies.size) { index ->
//            MovieCard(movie = movies[index])
//        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SliderHeader(modifier: Modifier = Modifier) {
    Card(
        onClick = { },
        modifier = modifier
            .fillMaxWidth()
            .width(300.dp)
            .height(120.dp),
        elevation = CardDefaults.cardElevation(10.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Image(
            painter = painterResource(id = R.drawable.img_slider_1),
            contentDescription = "Image Resep",
            modifier = modifier
                .height(120.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )

    }
}