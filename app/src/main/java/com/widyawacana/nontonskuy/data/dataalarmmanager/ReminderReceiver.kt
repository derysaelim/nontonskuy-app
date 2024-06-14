package com.widyawacana.nontonskuy.data.dataalarmmanager

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.widyawacana.nontonskuy.utils.NotificationKeys.RMNDR_NOTI_TITLE_KEY


class ReminderReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val scheduleNotificationService = context?.let { ReminderNotification(it) }
        val title: String = intent?.getStringExtra(RMNDR_NOTI_TITLE_KEY) ?: return
        scheduleNotificationService?.sendReminderNotification(title)
    }
}