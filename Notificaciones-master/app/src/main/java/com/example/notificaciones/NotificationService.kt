package com.example.notificaciones

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage


class NotificationService : FirebaseMessagingService() {
    override fun onMessageReceived(p0: RemoteMessage) {
        super.onMessageReceived(p0)

        var title = p0.notification?.title
        var text = p0.notification?.body

        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        val pendingIntent = PendingIntent.getActivity(this,
            0,
            intent,
            PendingIntent.FLAG_ONE_SHOT)

        var notification = NotificationCompat.Builder(applicationContext, "ID_CANAL")
            .setContentTitle(title)
            .setContentText(text)
            .setSmallIcon(android.R.drawable.ic_lock_idle_low_battery)
            .setAutoCancel(true)
            .setContentIntent(pendingIntent)


        var notificationManager = getSystemService(Context.NOTIFICATION_SERVICE)
                as NotificationManager

        var channel = NotificationChannel("ID_CANAL",
            "Notificaciones",
            NotificationManager.IMPORTANCE_HIGH)
        notificationManager.createNotificationChannel(channel)
        notificationManager.notify(100, notification.build())

        super.onMessageReceived(p0)
    }
}


