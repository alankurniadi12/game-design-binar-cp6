package com.binar.gamedesignbinarcp6.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.binar.gamedesignbinarcp6.MainActivity
import com.binar.gamedesignbinarcp6.database.Users
import com.binar.gamedesignbinarcp6.database.UsersRoomDatabase
import com.binar.gamedesignbinarcp6.databinding.ActivityLoginBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class LoginActivity : AppCompatActivity() {

    private val TAG = LoginActivity::class.java.simpleName
    private lateinit var binding: ActivityLoginBinding
    var mDB: UsersRoomDatabase? = null
    private lateinit var data: List<Users>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mDB = UsersRoomDatabase.getInstance(this)
    }

    override fun onStart() {
        super.onStart()
        GlobalScope.async {
            data = mDB?.UsersDao()?.getAllUsers()!!
            binding.btnLogin.setOnClickListener {
                var nameInDb: String? = null
                var numberInDb: String? = null
                val inputName = binding.edtUsername.text.toString()
                val inputNumber = binding.edtNohp.text.toString()
                runOnUiThread {
                    for (mData in data) {
                        if (inputName == mData.name) nameInDb = mData.name
                        if (inputNumber == mData.number) numberInDb = mData.number
                    }
                    if (nameInDb != null && numberInDb != null) {
                        startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                    } else {
                        Toast.makeText(
                            this@LoginActivity,
                            "PERIKSA KEMBALI NAMA DAN NUMBER!!",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
            binding.tvDontAlreadyAccount.setOnClickListener {
                startActivity(Intent(applicationContext, RegisterActivity::class.java))
            }
        }
    }
}