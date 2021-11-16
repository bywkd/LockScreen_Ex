package com.jww.lockscreen_ex

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.jww.lockscreen_ex.databinding.ActivityLockscreenBinding

class LockScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLockscreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLockscreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.addFlags(
            WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED or
                    WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD
                    or WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON
                    or WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON
        )
    }
}