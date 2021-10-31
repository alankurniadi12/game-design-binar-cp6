package com.binar.gamedesignbinarcp6.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.binar.gamedesignbinarcp6.database.Users
import com.binar.gamedesignbinarcp6.database.UsersRoomDatabase
import com.binar.gamedesignbinarcp6.databinding.ActivityRegisterBinding
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    var mDB: UsersRoomDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mDB = UsersRoomDatabase.getInstance(this)
    }

    @DelicateCoroutinesApi
    override fun onStart() {
        super.onStart()
        binding.btnSignUp.setOnClickListener {
            val users = Users(
                null,
                binding.edtUsername.text.toString(),
                binding.edtEmail.text.toString(),
                binding.edtNohp.text.toString()
            )

            GlobalScope.async {
                val result = mDB?.UsersDao()?.insert(users)
                runOnUiThread {
                    if (result != null) {
                        Toast.makeText(
                            this@RegisterActivity,
                            "Data Berhasil ditambahkan",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        Toast.makeText(
                            this@RegisterActivity,
                            "Data Gagal ditambahkan",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    finish()
                }
            }
        }
        binding.tvAlreadyAccount.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}