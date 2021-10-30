package com.binar.gamedesignbinarcp6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Window


class SplashScreen : AppCompatActivity() {

    private lateinit var handler: Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //menghilangkan ActionBar
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_splash_screen)
        handler = Handler()
        handler.postDelayed({

            val intent = Intent(this, LandingPageActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000L) //3000 L = 3 detik
    }
}