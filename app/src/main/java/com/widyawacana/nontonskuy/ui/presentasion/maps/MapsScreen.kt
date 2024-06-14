package com.widyawacana.nontonskuy.ui.presentasion.maps

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapType
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState
import com.widyawacana.nontonskuy.model.Bioskop

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MapsScreen(navController: NavController, listBioskop: List<Bioskop>, id: Int?) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color(0xFF000000)
            ), title = { Text(text = "Detail Maps", color = Color.White) }, navigationIcon = {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowLeft,
                        contentDescription = "Back Icon",
                        tint = Color.White
                    )
                }
            })
        }
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            val locationMaps = LatLng(listBioskop[0].lat, listBioskop[0].long)
            val cameraPositionState = rememberCameraPositionState {
                position = CameraPosition.fromLatLngZoom(locationMaps, 18f)
            }
            val properties by remember {
                mutableStateOf(MapProperties(mapType = MapType.NORMAL))
            }
            val uiSettings by remember {
                mutableStateOf(MapUiSettings(zoomControlsEnabled = true))
            }

            GoogleMap(
                modifier = Modifier.fillMaxSize(),
                cameraPositionState = cameraPositionState,
                properties = properties,
                uiSettings = uiSettings
            ) {
                Marker(
                    state = MarkerState(locationMaps),
                    title = listBioskop[0].title
                )
            }
        }

    }

}