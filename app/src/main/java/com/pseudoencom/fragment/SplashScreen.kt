package com.pseudoencom.fragment

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.pseudoencom.fragment.SplashActivity2

class SplashActivity : AppCompatActivity() {

    private val SPLASH_TIME_OUT:Long = 2550
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        var mediaPlayer = MediaPlayer.create(this, R.raw.start)
        mediaPlayer.start()



        Handler().postDelayed({


            startActivity(Intent(this, SplashActivity2::class.java))


            finish()
        }, SPLASH_TIME_OUT)
    }

}