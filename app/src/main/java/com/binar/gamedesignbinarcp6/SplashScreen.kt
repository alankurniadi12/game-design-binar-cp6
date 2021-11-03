package com.binar.gamedesignbinarcp6

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Window
import com.binar.gamedesignbinarcp6.helper.LoginPref


class SplashScreen : AppCompatActivity() {

    private lateinit var handler: Handler
    private lateinit var loginPref: LoginPref

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //menghilangkan ActionBar
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_splash_screen)

        loginPref = LoginPref(this)

        Handler(Looper.getMainLooper()).postDelayed({
            if (loginPref.sharedPreferences.contains(LoginPref.IS_LOGIN)) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                val intent = Intent(this, LandingPageActivity::class.java)
                startActivity(intent)
                finish()
            }

        }, 3000L) //3000 L = 3 detik

    }
}