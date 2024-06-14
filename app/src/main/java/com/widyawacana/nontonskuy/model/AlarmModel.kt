package com.widyawacana.nontonskuy.model

data class AlarmModel(
    val id: Int, // id alarm, bisa digunakan untuk mengidentifikasi alarm
    val title: String,
    val date: String,
    val time: String,
    val hargaTiket: String
)
