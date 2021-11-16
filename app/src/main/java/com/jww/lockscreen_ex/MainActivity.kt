package com.jww.lockscreen_ex

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jww.lockscreen_ex.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init() {
        bind()
    }

    private fun bind() {
        binding.btnStart.setOnClickListener {
            val intent = Intent(this, LockScreenService::class.java)
            startService(intent)
        }
        binding.btnStop.setOnClickListener {
            val intent = Intent(this, LockScreenService::class.java)
            stopService(intent)
        }
    }
}