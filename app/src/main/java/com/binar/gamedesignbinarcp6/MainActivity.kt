package com.binar.gamedesignbinarcp6

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.binar.gamedesignbinarcp6.databinding.ActivityMainBinding
import com.binar.gamedesignbinarcp6.helper.LoginPref

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var loginPref: LoginPref

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loginPref = LoginPref(this)

        binding.btnLogout.setOnClickListener {
            loginPref.clearStatusLogin()
            finish()
            isDestroyed
        }
    }
}