package com.binar.gamedesignbinarcp6.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.binar.gamedesignbinarcp6.database.Users
import com.binar.gamedesignbinarcp6.database.UsersRoomDatabase
import com.binar.gamedesignbinarcp6.databinding.ActivityRegisterBinding
import com.binar.gamedesignbinarcp6.mvp.MainPresenterImpl
import com.binar.gamedesignbinarcp6.mvp.MainView
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class RegisterActivity : AppCompatActivity(), MainView {

    private lateinit var binding: ActivityRegisterBinding
    var mDB: UsersRoomDatabase? = null
    private lateinit var mainPresenterImpl: MainPresenterImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mDB = UsersRoomDatabase.builDataBase(this)
        mainPresenterImpl = MainPresenterImpl(this, this)


        binding.btnSignUp.setOnClickListener {

            val name = binding.edtUsername.text.toString()
            val email = binding.edtEmail.text.toString()
            val number = binding.edtNohp.text.toString()
            val users = Users(null, name, email, number)

            if (name.isNotEmpty() && email.isNotEmpty() && number.isNotEmpty()) {
                GlobalScope.async {

                    mainPresenterImpl.addUser(users)
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

    override fun onGetUsers(users: List<Users>) {
    }

}