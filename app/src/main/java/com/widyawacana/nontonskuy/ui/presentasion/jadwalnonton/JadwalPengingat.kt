package com.widyawacana.nontonskuy.ui

import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.room.Room
import com.widyawacana.nontonskuy.data.Database.AppDatabase
import com.widyawacana.nontonskuy.data.Reminder
import com.widyawacana.nontonskuy.data.Repository.ReminderRepository
import com.widyawacana.nontonskuy.utils.setAlarm
import com.widyawacana.nontonskuy.viewmodel.ReminderViewModel
import com.widyawacana.nontonskuy.viewmodel.ReminderViewModelFactory


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JadwalPengingat(context: Context) {
    val db = Room.databaseBuilder(context, AppDatabase::class.java, "app-database").build()
    val repository = ReminderRepository(db.reminderDao())
    val viewModel: ReminderViewModel = viewModel(factory = ReminderViewModelFactory(repository))

    val judulFilm = remember { mutableStateOf("") }
    val namaBioskop = remember { mutableStateOf("") }
    val tglNontonFilm = remember { mutableStateOf("") }
    val jamNontonFilm = remember { mutableStateOf("") }
    val hargaTiket = remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Jadwal Pengingat",
                        color = Color.Black,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White
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
            Text(
                text = "Judul Film",
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            OutlinedTextField(
                value = judulFilm.value,
                onValueChange = { judulFilm.value = it },
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text(text = "Masukkan judul film") }
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "Nama Bioskop",
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            OutlinedTextField(
                value = namaBioskop.value,
                onValueChange = { namaBioskop.value = it },
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text(text = "Masukkan nama Bioskop") }
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "Tanggal Nonton",
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            OutlinedTextField(
                value = tglNontonFilm.value,
                onValueChange = { tglNontonFilm.value = it },
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text(text = "Masukkan tanggal nonton") }
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "Jam Nonton",
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            OutlinedTextField(
                value = jamNontonFilm.value,
                onValueChange = { jamNontonFilm.value = it },
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text(text = "Masukkan Jam nonton") }
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "Harga Tiket",
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            OutlinedTextField(
                value = hargaTiket.value,
                onValueChange = { hargaTiket.value = it },
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text(text = "Masukkan Harga Tiket") }
            )
            Spacer(modifier = Modifier.height(24.dp))
            Button(
                onClick = {
                    val reminder = Reminder(
                        judulFilm = judulFilm.value,
                        namaBioskop = namaBioskop.value,
                        tglNontonFilm = tglNontonFilm.value,
                        jamNontonFilm = jamNontonFilm.value,
                        hargaTiket = hargaTiket.value
                    )
                    viewModel.addReminder(reminder)
                    setAlarm(context, reminder)
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF000000)
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
            ) {
                Text(
                    text = "SIMPAN",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.White
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            LazyColumn {
                items(viewModel.reminders) { savedReminder ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.White,
                            contentColor = Color.Black
                        )
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {
                            Text(
                                text = "Judul Film: ${savedReminder.judulFilm}",
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp,
                                modifier = Modifier.align(Alignment.Start)
                            )
                            Text(
                                text = "Nama Bioskop: ${savedReminder.namaBioskop}",
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp,
                                modifier = Modifier.align(Alignment.Start)
                            )
                            Text(
                                text = "Harga Tiket: ${savedReminder.hargaTiket}",
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp,
                                modifier = Modifier.align(Alignment.Start)
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Row(
                                horizontalArrangement = Arrangement.SpaceBetween,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text(
                                    text = "Jam Nonton: ${savedReminder.jamNontonFilm}",
                                    fontSize = 16.sp,
                                    modifier = Modifier.align(Alignment.Start)
                                )
                                Text(
                                    text = "Tanggal Nonton: ${savedReminder.tglNontonFilm}",
                                    fontSize = 16.sp,
                                    modifier = Modifier.align(Alignment.End)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
