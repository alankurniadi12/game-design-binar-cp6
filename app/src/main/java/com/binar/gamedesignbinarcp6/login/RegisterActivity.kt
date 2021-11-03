package com.binar.gamedesignbinarcp6.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
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

        binding.btnSignUp.setOnClickListener {
            val name = binding.edtUsername.text.toString()
            val email = binding.edtEmail.text.toString()
            val number = binding.edtNohp.text.toString()
            val users = Users(null, name, email, number)

            if (name.isNotEmpty() && email.isNotEmpty() && number.isNotEmpty()) {
                GlobalScope.async {
                    mDB?.UsersDao()?.insert(users)
                    runOnUiThread {
                        Toast.makeText(this@RegisterActivity, "Data Berhasil ditambahkan", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this@RegisterActivity, LoginActivity::class.java))
                    }
                }
            } else{
                Toast.makeText(this@RegisterActivity, "Lengkapi Form", Toast.LENGTH_SHORT).show()
            }
        }
        binding.tvAlreadyAccount.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }

}