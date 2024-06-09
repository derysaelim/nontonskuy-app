package com.widyawacana.nontonskuy.utils

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class AlarmReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        // Display a notification or toast message
        Toast.makeText(context, "Reminder: ${intent.getStringExtra("judulFilm")}", Toast.LENGTH_LONG).show()
    }
}

