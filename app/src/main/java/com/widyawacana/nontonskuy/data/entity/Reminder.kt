package com.widyawacana.nontonskuy.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "reminders")
data class Reminder(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val judulFilm: String,
    val namaBioskop: String,
    val tglNontonFilm: String,
    val jamNontonFilm: String,
    val hargaTiket: String
)
