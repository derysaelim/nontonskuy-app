package com.widyawacana.nontonskuy.utils


import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import com.widyawacana.nontonskuy.data.Reminder
import java.text.SimpleDateFormat
import java.util.*

fun setAlarm(context: Context, reminder: Reminder) {
    val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
    val intent = Intent(context, AlarmReceiver::class.java).apply {
        putExtra("judulFilm", reminder.judulFilm)
    }

    val pendingIntent = PendingIntent.getBroadcast(
        context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
    )

    val formatter = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault())
    val dateTime = "${reminder.tglNontonFilm} ${reminder.jamNontonFilm}"
    val alarmTime = formatter.parse(dateTime)?.time ?: System.currentTimeMillis()

    alarmManager.setExactAndAllowWhileIdle(
        AlarmManager.RTC_WAKEUP,
        alarmTime,
        pendingIntent
    )
}
