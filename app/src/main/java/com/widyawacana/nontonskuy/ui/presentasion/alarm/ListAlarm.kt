package com.widyawacana.nontonskuy.ui.presentasion.alarm


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.widyawacana.nontonskuy.model.AlarmModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListAlarmScreen(alarms: List<AlarmModel>) {
    Scaffold(
        topBar = {
            TopAppBar(
//                    title = {
////                    Text(
////                        text = "Detail Resep",
////                        color = Color.White) } },
////                    navigationIcon = {
////                    IconButton(onClick = { navController.popBackStack() }) {
////                        Icon(
////                            imageVector = Icons.Default.ArrowBackIosNew,
////                            contentDescription = "Back Icon",
////                            tint = Color.White
////                        )
////                    },
                title = {
                    Text(
                        text = "List Alarm",
                        color = Color.White,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Black
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            alarms.forEach { alarm ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(text = "Judul: ${alarm.title}")
                        Text(text = "Tanggal: ${alarm.date}")
                        Text(text = "Waktu: ${alarm.time}")
                        Text(text = "Harga Tiket: ${alarm.hargaTiket}")
                    }
                }
            }
        }
    }
}
