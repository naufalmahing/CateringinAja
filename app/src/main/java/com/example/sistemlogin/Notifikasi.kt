package com.example.sistemlogin

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat


class Notifikasi(val context: Context) {

    fun show(msg: String) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "CateringinAja"
            val descriptionText = "Notifikasi pesanan"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel("CateringinAja", name, importance).apply {
                description = descriptionText
            }
            val manager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(channel)
        }

        val builder = NotificationCompat.Builder(context, "CateringinAja")
        builder.setContentTitle("CateringinAja")
        builder.setContentText(msg)
        builder.setSmallIcon(R.drawable.ic_launcher_foreground)
        builder.setAutoCancel(true)
        builder.setPriority(NotificationCompat.PRIORITY_DEFAULT)

        val managerCompat = NotificationManagerCompat.from(context)
        managerCompat.notify(1, builder.build())
    }
}