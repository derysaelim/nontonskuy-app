package com.widyawacana.nontonskuy.ui.presentasion.maps

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.widyawacana.nontonskuy.data.local.dummy.DummyData
import com.widyawacana.nontonskuy.model.Bioskop
import com.widyawacana.nontonskuy.ui.navigation.Screen
import com.widyawacana.nontonskuy.ui.presentasion.maps.component.CardBioskopItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BioskopScreen(
    navController: NavController,
    bioskops: List<Bioskop> = DummyData.listBioskop,
    modifier: Modifier = Modifier
) {
    Scaffold(topBar = {
        CenterAlignedTopAppBar(colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(0xFF000000)
        ), title = { Text(text = "List Bioskop", color = Color.White) }, navigationIcon = {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowLeft,
                    contentDescription = "Back Icon",
                    tint = Color.White
                )
            }
        })
    }, modifier = Modifier
    ) { contentPadding ->
        LazyColumn(
            modifier = modifier
                .padding(contentPadding),
            contentPadding = PaddingValues(24.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(bioskops, key = { it.id }) {
                CardBioskopItem(listBioskop = it) { id ->
                    navController.navigate(Screen.Maps.route + "/$id")
                }
            }
        }
    }
}

@Preview
@Composable
private fun BioskopScreenPrev() {
    BioskopScreen(navController = rememberNavController())
}