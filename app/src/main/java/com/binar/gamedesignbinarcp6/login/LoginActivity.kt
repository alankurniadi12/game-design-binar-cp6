package com.binar.gamedesignbinarcp6.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.binar.gamedesignbinarcp6.MainActivity
import com.binar.gamedesignbinarcp6.database.Users
import com.binar.gamedesignbinarcp6.database.UsersRoomDatabase
import com.binar.gamedesignbinarcp6.databinding.ActivityLoginBinding
import com.binar.gamedesignbinarcp6.helper.LoginPref
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class LoginActivity : AppCompatActivity() {

    private val TAG = LoginActivity::class.java.simpleName
    private lateinit var binding: ActivityLoginBinding
    var mDB: UsersRoomDatabase? = null
    private lateinit var data: List<Users>

    private lateinit var loginPref: LoginPref


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loginPref = LoginPref(this)
        mDB = UsersRoomDatabase.getInstance(this)

        GlobalScope.async {
            data = mDB?.UsersDao()?.getAllUsers()!!
            binding.btnLogin.setOnClickListener {
                var nameInDb: String? = null
                var numberInDb: String? = null
                val inputName = binding.edtUsername.text.toString()
                val inputNumber = binding.edtNohp.text.toString()

                if (inputName.isNotEmpty() && inputNumber.isNotEmpty()) {
                    runOnUiThread {
                        for (mData in data) {
                            if (inputName == mData.name) nameInDb = mData.name
                            if (inputNumber == mData.number) numberInDb = mData.number
                        }
                        if (nameInDb != null && numberInDb != null) {
                            loginPref.setLoginPref()
                            startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                        } else {
                            Toast.makeText(
                                this@LoginActivity,
                                "PERIKSA KEMBALI NAMA DAN NUMBER!!",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                } else {
                    Toast.makeText(this@LoginActivity, "Lengkapi Form", Toast.LENGTH_SHORT).show()
                }

            }
            binding.tvDontAlreadyAccount.setOnClickListener {
                startActivity(Intent(applicationContext, RegisterActivity::class.java))
            }
        }
    }
}