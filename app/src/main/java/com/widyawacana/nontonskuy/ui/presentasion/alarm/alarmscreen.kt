package com.widyawacana.nontonskuy.ui.presentasion.alarm


import android.widget.Toast
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TimePicker
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.widyawacana.nontonskuy.model.AlarmModel
import com.widyawacana.nontonskuy.ui.presentasion.alarm.componentalarm.TimePickerDialog
import com.widyawacana.nontonskuy.utils.cancelNotification
import com.widyawacana.nontonskuy.utils.scheduleNotification
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlarmScreen(
    modifier: Modifier = Modifier,
    scrollState: ScrollState = rememberScrollState()

) {
    val context = LocalContext.current
    var alarmList by remember { mutableStateOf(emptyList<AlarmModel>()) }

    // Callback untuk menambah alarm ke daftar
    val addAlarm: (AlarmModel) -> Unit = { alarm ->
        alarmList = alarmList + alarm
    }

    val date = remember { Calendar.getInstance().timeInMillis }
    val formatter = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())

    var scheduleText by remember { mutableStateOf("") }
    var scheduleDate by remember { mutableStateOf("") }
    var scheduleTime by rememberSaveable { mutableStateOf("") }

    val datePickerState = rememberDatePickerState(initialSelectedDateMillis = date)
    var showDatePicker by remember { mutableStateOf(false) }

    val timePickerState = rememberTimePickerState()
    var showTimePicker by remember { mutableStateOf(false) }

    var HargaTiket by rememberSaveable { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
//                title = {
//                    Text(
//                        text = "Detail Resep",
//                        color = Color.White) } },
//                    navigationIcon = {
//                    IconButton(onClick = { navController.popBackStack() }) {
//                        Icon(
//                            imageVector = Icons.Default.ArrowBackIosNew,
//                            contentDescription = "Back Icon",
//                            tint = Color.White
//                        )
//                    },
                title = {
                    Text(
                        text = "Jadwal Pengingat",
                        color = Color.White,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold
                    )
                },
                actions = {
//                    navController.navigate("list_alarm_screen")
                    IconButton(onClick = {  }) { // Navigasi ke halaman daftar alarm saat ikon notifikasi diklik
                        Icon(
                            imageVector = Icons.Default.Notifications,
                            contentDescription = "Notifikasi",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Black
                )
            )
        }
    ) { innerPadding ->
        if (showDatePicker) {
            DatePickerDialog(
                onDismissRequest = { showDatePicker = false },
                confirmButton = {
                    TextButton(
                        onClick = {
                            val selectedDate = Calendar.getInstance().apply {
                                timeInMillis = datePickerState.selectedDateMillis!!
                            }
                            scheduleDate = formatter.format(selectedDate.time)
                            showDatePicker = false
                        }
                    ) {
                        Text("OK")
                    }
                },
                dismissButton = {
                    TextButton(onClick = { showDatePicker = false }) {
                        Text("Cancel")
                    }
                }
            ) {
                DatePicker(state = datePickerState)
            }
        }

        if (showTimePicker) {
            TimePickerDialog(
                onDismissRequest = { showTimePicker = false },
                confirmButton = {
                    TextButton(
                        onClick = {
                            scheduleTime = "${timePickerState.hour}:${timePickerState.minute}"
                            showTimePicker = false
                        }
                    ) {
                        Text("OK")
                    }
                },
                dismissButton = {
                    TextButton(
                        onClick = { showTimePicker = false }
                    ) {
                        Text("Cancel")
                    }
                }
            ) {
                TimePicker(state = timePickerState)
            }
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            Text(
                text = "Nama Judul",
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            OutlinedTextField(
                value = scheduleText,
                onValueChange = { if (it.length <= 25) scheduleText = it },
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text(text = "Masukkan Nama Judul") }
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "Atur Tanggal",
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            OutlinedTextField(
                value = scheduleDate,
                onValueChange = { scheduleDate = it },
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text(text = "Masukkan Tanggal Nonton") },
                trailingIcon = {
                    IconButton(onClick = { showDatePicker = true }) {
                        Icon(imageVector = Icons.Default.DateRange, contentDescription = "Select Date")
                    }
                }
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "Atur Jam",
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            OutlinedTextField(
                value = scheduleTime,
                onValueChange = { scheduleTime = it },
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text(text = "Masukkan jam Nonton") },
                trailingIcon = {
                    IconButton(onClick = { showTimePicker = true }) {
                        Icon(imageVector = Icons.Default.AddCircle, contentDescription = "Select Time")
                    }
                }
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "Harga Tiket",
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            OutlinedTextField(
                value = HargaTiket,
                onValueChange = { HargaTiket = it },
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text(text = "Masukan Harga Tiket") }
            )
            Spacer(modifier = Modifier.height(24.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween  // Use Arrangement.SpaceBetween for even spacing
            ) {
                Button(
                    onClick = {
                        cancelNotification(context)
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Red.copy(0.8f)
                    ),
                    shape = MaterialTheme.shapes.small,
                    modifier = Modifier.height(56.dp)
                ) {
                    Text(
                        text = "Batal",
                        style = MaterialTheme.typography.bodyLarge,
                        color = Color.White
                    )
                }

                Spacer(modifier = Modifier.weight(1f))  // Use weight modifier for flexible spacer

                Button(
                    onClick = {
                        if (scheduleText.isBlank() || scheduleDate.isBlank() || scheduleTime.isBlank()) {
                            Toast.makeText(
                                context,
                                "Semua field wajib diisi!",
                                Toast.LENGTH_SHORT
                            ).show()
                        } else {
                            scheduleNotification(
                                context,
                                timePickerState,
                                datePickerState,
                                scheduleText
                            )
                            scheduleText = ""
                            scheduleDate = ""
                            scheduleTime = ""
                            HargaTiket = ""

                        }
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Black
                    ),
                    shape = MaterialTheme.shapes.small,
                    modifier = Modifier.height(56.dp)
                ) {
                    Text(
                        text = "SIMPAN",
                        style = MaterialTheme.typography.bodyLarge,
                        color = Color.White
                    )
                }
            }
        }
    }
}