package com.binar.gamedesignbinarcp6.ui

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.widget.Toast
import com.binar.gamedesignbinarcp6.databinding.ActivityMenuBinding
import com.binar.gamedesignbinarcp6.helper.LoginPref
import com.binar.gamedesignbinarcp6.login.LoginActivity
import com.google.android.material.snackbar.Snackbar

class MenuActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMenuBinding
    private var backToast: Toast? = null
    private var backPress: Long = 0
    private lateinit var loginPref: LoginPref

    companion object {
        const val KEY_NAME = "key_name"
        const val KEY_NAME_FROM_DIALOG = "key_name_from_dialog"
        const val KEY_NAME_FROM_MAIN = "key_name_from_main"
        const val TAG = "MenuActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loginPref = LoginPref(this)

        binding.tvKeluar.setOnClickListener {
            loginPref.clearStatusLogin()
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }

    override fun onStart() {
        super.onStart()

        val nameFromLandingPage = intent.getStringExtra(KEY_NAME)
        val nameFromMain = intent.getStringExtra(KEY_NAME_FROM_MAIN)
        val nameFromDialog = intent.getStringExtra(KEY_NAME_FROM_DIALOG)

        when {
            nameFromLandingPage != null -> {
                initFromLandingPage(nameFromLandingPage)
            }
            nameFromMain != null -> {
                initFromMain(nameFromMain)
            }
            else -> {
                initFromDialog(nameFromDialog)
            }
        }
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    private fun initFromMain(nameFromMain: String?) {
        binding.tvName.text = nameFromMain
        binding.tvName2.text = nameFromMain
        battleWithPlayer(nameFromMain)
        battleWithCom(nameFromMain)
        showSnackBar(nameFromMain)
    }

    private fun initFromDialog(nameFromDialog: String?) {
        binding.tvName.text = nameFromDialog
        binding.tvName2.text = nameFromDialog
        battleWithPlayer(nameFromDialog)
        battleWithCom(nameFromDialog)
        showSnackBar(nameFromDialog)
    }

    private fun initFromLandingPage(name: String?) {
        binding.tvName.text = name
        binding.tvName2.text = name
        battleWithPlayer(name)
        battleWithCom(name)
        showSnackBar(name)
    }


    private fun battleWithPlayer(name: String?) {
        binding.imgVsPlayer.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra(MainActivity.EXTRA_NAME, name)
            intent.putExtra(MainActivity.EXTRA_VS, "vsplayer")
            startActivity(intent)
        }
    }

    private fun battleWithCom(name: String?) {
        binding.imgVsCom.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra(MainActivity.EXTRA_NAME, name)
            startActivity(intent)
        }
    }

    private fun showSnackBar(name: String?) {
        val snackbar =
            Snackbar.make(binding.root, "Selamat Datang $name", Snackbar.LENGTH_INDEFINITE)
        snackbar.apply {
            view.setBackgroundColor(Color.BLACK)
            setAction("Tutup") { dismiss() }
            show()
        }
    }

    /*override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        backToast = Toast.makeText(this, "Press back again to exit!", Toast.LENGTH_SHORT)
        if (backPress + 2000 > System.currentTimeMillis()) {
            val intent = Intent(Intent.ACTION_MAIN)
            intent.addCategory(Intent.CATEGORY_HOME)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            backToast?.cancel()
            return super.onKeyDown(keyCode, event)
        } else {
            backToast?.show()
        }
        backPress = System.currentTimeMillis()
        return true
    }*/
}