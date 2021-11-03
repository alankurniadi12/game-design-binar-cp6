package com.binar.gamedesignbinarcp6.ui

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.binar.gamedesignbinarcp6.databinding.ActivityMainBinding
import com.binar.gamedesignbinarcp6.helper.ResultGameVsCom
import com.binar.gamedesignbinarcp6.helper.ResultGameVsPlayer
import com.binar.gamedesignbinarcp6.helper.SetBackgroundChoice
import com.binar.gamedesignbinarcp6.helper.Utils.PAPER
import com.binar.gamedesignbinarcp6.helper.Utils.ROCK
import com.binar.gamedesignbinarcp6.helper.Utils.SCISSORS

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private lateinit var namePlayer: String
    private lateinit var versus: String

    var choice1 = ""
    var choice2 = ""
    val player2 = "Player 2"
    val comList = listOf("GUNTING", "BATU", "KERTAS")

    private val setBgChoice = SetBackgroundChoice(this)
    private val resultGameVsPlayer = ResultGameVsPlayer(this)
    private val resultGameVsCom = ResultGameVsCom(this)

    companion object {
        const val EXTRA_NAME = "name"
        const val EXTRA_VS = "extra_vs"
        const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setOnClickListener()
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onStart() {
        super.onStart()
        namePlayer = intent.getStringExtra(EXTRA_NAME).toString()
        versus = intent.getStringExtra(EXTRA_VS).toString()
        battleWith(versus)
    }

    override fun onResume() {
        super.onResume()
        binding.tvNameMain.text = namePlayer
        if (versus.isNotEmpty()) {
            binding.tvPlayer2.text = player2
        }
    }

    private fun setOnClickListener() {
        binding.imgClose.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            intent.putExtra(MenuActivity.KEY_NAME_FROM_MAIN, namePlayer)
            startActivity(intent)
        }
        binding.imgRefresh.setOnClickListener {
            finish()
            startActivity(intent)
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun battleWith(vS: String?) {
        if (vS != "vsplayer") {
            binding.imgGunting.setOnClickListener {
                resultGameVsCom.playerChoiceGunting(namePlayer, SCISSORS, comList.random())
            }
            binding.imgBatu.setOnClickListener {
                resultGameVsCom.playerChoiceBatu(namePlayer, ROCK, comList.random())
            }
            binding.imgKertas.setOnClickListener {
                resultGameVsCom.playerChoiceKertas(namePlayer, PAPER, comList.random())
            }
        } else {
            //Player1
            binding.imgBatu.setOnClickListener {
                choice1 = ROCK
                calculateGame()
            }
            binding.imgKertas.setOnClickListener {
                choice1 = PAPER
                calculateGame()
            }
            binding.imgGunting.setOnClickListener {
                choice1 = SCISSORS
                calculateGame()
            }
            //Player2
            binding.imgComBatu.setOnClickListener {
                choice2 = ROCK
                calculateGame()
            }
            binding.imgComKertas.setOnClickListener {
                choice2 = PAPER
                calculateGame()
            }
            binding.imgComGunting.setOnClickListener {
                choice2 = SCISSORS
                calculateGame()
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun calculateGame() {
        if (choice1 != "" && choice2 != "") {
            setBgChoice.backgroundChoicePlayer1(choice1)
            setBgChoice.backgroundChoicePlayer2(choice2)
            resultGameVsPlayer.playerChoice(namePlayer, choice1, choice2)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, MenuActivity::class.java)
        intent.putExtra(MenuActivity.KEY_NAME_FROM_MAIN, namePlayer)
        startActivity(intent)
    }
}