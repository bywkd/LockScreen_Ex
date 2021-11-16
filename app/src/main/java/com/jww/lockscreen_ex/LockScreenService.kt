package com.jww.lockscreen_ex

import android.app.Service
import android.content.Intent
import android.content.IntentFilter
import android.os.IBinder

class LockScreenService : Service() {
    private var receiver: LockScreenReceiver? = null
    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        receiver = LockScreenReceiver()
        val filter = IntentFilter(Intent.ACTION_SCREEN_OFF)
        filter.addAction(Intent.ACTION_SCREEN_ON)

        registerReceiver(receiver, filter)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        super.onStartCommand(intent, flags, startId)
        intent?.action ?: let {
            receiver ?: let {
                receiver = LockScreenReceiver()
                val filter = IntentFilter(Intent.ACTION_SCREEN_OFF)
                filter.addAction(Intent.ACTION_SCREEN_ON)
            }
        }
        return START_REDELIVER_INTENT
    }

    override fun onDestroy() {
        super.onDestroy()
        receiver?.let {
            unregisterReceiver(it)
        }
    }
}