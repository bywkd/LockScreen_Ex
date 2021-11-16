package com.jww.lockscreen_ex

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK

class LockScreenReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {

        when (intent.action) {
            Intent.ACTION_SCREEN_OFF -> {
                val i = Intent(context, LockScreenActivity::class.java)
                i.addFlags(FLAG_ACTIVITY_NEW_TASK)
                context.startActivity(i)
            }
        }
    }
}