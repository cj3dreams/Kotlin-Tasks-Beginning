package com.pseudoencom.fragment

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.pseudoencom.fragment.MainActivity
import com.pseudoencom.fragment.R

class SplashActivity2 : AppCompatActivity() {
    private val SPLASH_TIME_OUT: Long = 1600
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen2)
        Handler().postDelayed({


            startActivity(Intent(this, MainActivity::class.java))


            finish()
        }, SPLASH_TIME_OUT)
    }

}