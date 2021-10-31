package com.binar.gamedesignbinarcp6.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.binar.gamedesignbinarcp6.R
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
                val dataNameReady = mDB?.UsersDao()?.getUsersByName(inputName)
                val dataNumberReady = mDB?.UsersDao()?.getUsersByNumber(inputNumber)
                if (dataNameReady != null && dataNumberReady != null) {

                }
            }

        }
    }
}