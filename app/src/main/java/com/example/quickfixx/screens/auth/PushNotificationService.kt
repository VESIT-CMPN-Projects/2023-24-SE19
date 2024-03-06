package com.example.quickfixx.screens.auth

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import com.example.quickfixx.R
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage


class PushNotificationService: FirebaseMessagingService() {
//    override fun onMessageReceived(message: RemoteMessage) {
//        super.onMessageReceived(message)
//   }
//
//    override fun onNewToken(token: String) {
//        super.onNewToken(token)
//    }
    private val TAG: String? = "MyFirebaseMsgService"
    private val CHANNEL_ID = "Your_Channel_ID"

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)
        Log.d(TAG, "From: " + remoteMessage.from)
        showNotification(remoteMessage.notification!!.title, remoteMessage.notification!!.body)

        if (remoteMessage.notification != null) {
            Log.d(TAG, "Notification Message Body: " + remoteMessage.notification!!.body)
            // Handle notification message
        }

        // Check if message contains a data payload
        if (remoteMessage.data.isNotEmpty()) {
            Log.d(TAG, "Data Payload: " + remoteMessage.data)
            // Handle data payload
        }
    }

    private fun showNotification(title: String?, body: String?) {
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        // Check Android Oreo (API 26) and higher for notification channels
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID,
                "Notif channel",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            notificationManager.createNotificationChannel(channel)
        }

        val notificationBuilder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle(title)
            .setContentText(body)
            .setSmallIcon(R.drawable.qf_app_logo)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setAutoCancel(true)

        notificationManager.notify(0, notificationBuilder.build())
    }

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        // If you want to handle new token
    }
}