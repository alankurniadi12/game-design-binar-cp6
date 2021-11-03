package com.binar.gamedesignbinarcp6

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.binar.gamedesignbinarcp6.databinding.ActivityMainBinding
import com.binar.gamedesignbinarcp6.helper.LoginPref
import com.binar.gamedesignbinarcp6.login.LoginActivity
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var loginPref: LoginPref

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loginPref = LoginPref(this)

        val nama = intent.getStringExtra("nama") ?: "not found"
        binding.tvPvp.text = "$nama vs Player 2"
        binding.tvVscom.text = "$nama vs CPU"

        val snack = Snackbar.make(
            binding.ivVscom,
            "Selamat datang $nama..",
            Snackbar.LENGTH_SHORT
        )
        snack.show()

        binding.ivPvp.setOnClickListener {
            val mode = "pvp"
            val intent = Intent(this@MainActivity, SecondActivity::class.java).apply {
                putExtra("mode", mode)
                putExtra("nama", nama)
            }
            startActivity(intent)
        }

        binding.ivVscom.setOnClickListener {
            val mode = "vscom"
            val intent = Intent(this@MainActivity, SecondActivity::class.java).apply {
                putExtra("mode", mode)
                putExtra("nama", nama)
            }
            startActivity(intent)
        }

        binding.tvKeluar.setOnClickListener{
            loginPref.clearStatusLogin()
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}