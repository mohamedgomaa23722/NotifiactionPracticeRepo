package com.example.android.eggtimernotifications

import android.app.NotificationManager
import android.content.ContentValues.TAG
import android.util.Log
import androidx.core.content.ContextCompat
import com.example.android.eggtimernotifications.util.sendNotification
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService:FirebaseMessagingService() {
    override fun onMessageReceived(Message: RemoteMessage?) {
        Log.d(TAG, "From : ${Message?.from}")

        Message?.notification?.let {
            Log.d(TAG, "From : ${it.body}")
            sendNotification(it.body!!)
        }
    }

    private fun sendNotification(body: String) {
        val notificationManager = ContextCompat.getSystemService(applicationContext,NotificationManager::class.java) as NotificationManager
        notificationManager.sendNotification(body,applicationContext)
    }

    override fun onNewToken(token: String?) {
        Log.d(TAG, "onNewToken: $token")
        RegisterTokenToServer(token)
    }

    fun RegisterTokenToServer(token: String?) {
        Log.d(TAG, "onNewToken: $token")
    }
}