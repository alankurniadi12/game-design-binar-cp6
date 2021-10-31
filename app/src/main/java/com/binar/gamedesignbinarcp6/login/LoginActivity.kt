package com.binar.gamedesignbinarcp6.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.binar.gamedesignbinarcp6.MainActivity
import com.binar.gamedesignbinarcp6.R
import com.binar.gamedesignbinarcp6.database.Users
import com.binar.gamedesignbinarcp6.database.UsersRoomDatabase
import com.binar.gamedesignbinarcp6.databinding.ActivityLoginBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    var mDB: UsersRoomDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mDB = UsersRoomDatabase.getInstance(this)
    }

    override fun onStart() {
        super.onStart()
        binding.btnLogin.setOnClickListener {
            val inputName = binding.edtUsername.text.toString()
            val inputNumber = binding.edtNohp.text.toString()

            GlobalScope.async {
                val dataReady = mDB?.UsersDao()?.getAllUsers()
                runOnUiThread {
                    if (dataReady != null) {
                        for (data in dataReady) {
                            when {
                                inputName != data.name -> {
                                    Toast.makeText(this@LoginActivity, "$inputName\nTIDAK TERDAFTAR!!", Toast.LENGTH_SHORT).show()
                                }
                                inputNumber != data.number -> {
                                    Toast.makeText(this@LoginActivity, "NUMBER SALAH!!", Toast.LENGTH_SHORT).show()
                                }
                                else -> {
                                    startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                                }
                            }
                        }
                    }
                }
            }
        }

        binding.tvDontAlreadyAccount.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
}