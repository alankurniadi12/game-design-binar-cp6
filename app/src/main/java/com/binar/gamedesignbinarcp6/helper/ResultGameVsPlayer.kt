package com.binar.gamedesignbinarcp6.helper

import android.os.Build
import androidx.annotation.RequiresApi
import com.binar.gamedesignbinarcp6.R
import com.binar.gamedesignbinarcp6.helper.Utils.DRAW
import com.binar.gamedesignbinarcp6.helper.Utils.PAPER
import com.binar.gamedesignbinarcp6.helper.Utils.ROCK
import com.binar.gamedesignbinarcp6.helper.Utils.SCISSORS
import com.binar.gamedesignbinarcp6.helper.Utils.YOU_LOSE
import com.binar.gamedesignbinarcp6.helper.Utils.YOU_WIN
import com.binar.gamedesignbinarcp6.helper.Utils.openDialogResult
import com.binar.gamedesignbinarcp6.helper.Utils.showLogInfo
import com.binar.gamedesignbinarcp6.helper.Utils.showToast
import com.binar.gamedesignbinarcp6.ui.MainActivity

open class ResultGameVsPlayer(private val activity: MainActivity) {

    private val setBgChoice = SetBackgroundChoice(activity)

    @RequiresApi(Build.VERSION_CODES.M)
    open fun playerChoice(
        namePlayer1: String,
        choicePlayer1: String,
        choicePlayer2: String
    ) {
        //DRAW
        if (choicePlayer1 == ROCK && choicePlayer2 == ROCK) {
            setBgChoice.backgroundChoicePlayer1(ROCK)
            setBgChoice.backgroundChoicePlayer2(ROCK)
            activity.binding.imgVs.setImageResource(R.drawable.draw)
            openDialogResult(activity, namePlayer1, DRAW)
            showToast(activity, "${activity.player2} Memilih $ROCK")
            showLogInfo("MainActivity", "$namePlayer1: $ROCK, Player2: $ROCK")

        } else if (choicePlayer1 == PAPER && choicePlayer2 == PAPER) {
            setBgChoice.backgroundChoicePlayer1(PAPER)
            setBgChoice.backgroundChoicePlayer2(PAPER)
            activity.binding.imgVs.setImageResource(R.drawable.draw)
            openDialogResult(activity, namePlayer1, DRAW)
            showToast(activity, "Pemain 2 Memilih $PAPER")
            showLogInfo("MainActivity", "$namePlayer1: $PAPER, Player2: $PAPER")

        } else if (choicePlayer1 == SCISSORS && choicePlayer2 == SCISSORS) {
            setBgChoice.backgroundChoicePlayer1(SCISSORS)
            setBgChoice.backgroundChoicePlayer2(SCISSORS)
            activity.binding.imgVs.setImageResource(R.drawable.draw)
            openDialogResult(activity, namePlayer1, DRAW)
            showToast(activity, "Pemain 2 Memilih $SCISSORS")
            showLogInfo("MainActivity", "$namePlayer1: $SCISSORS, Player2: $SCISSORS")
        }

        //PLAYER 1 WINNER
        if (choicePlayer1 == ROCK && choicePlayer2 == SCISSORS) {
            setBgChoice.backgroundChoicePlayer1(ROCK)
            setBgChoice.backgroundChoicePlayer2(SCISSORS)
            activity.binding.imgVs.setImageResource(R.drawable.you_win)
            openDialogResult(activity, namePlayer1, YOU_WIN)
            showToast(activity, "Pemain 2 Memilih $SCISSORS")
            showLogInfo("MainActivity", "$namePlayer1: $ROCK, Player2: $SCISSORS")

        } else if (choicePlayer1 == PAPER && choicePlayer2 == ROCK) {
            setBgChoice.backgroundChoicePlayer1(PAPER)
            setBgChoice.backgroundChoicePlayer2(ROCK)
            activity.binding.imgVs.setImageResource(R.drawable.you_win)
            openDialogResult(activity, namePlayer1, YOU_WIN)
            showToast(activity, "Pemain 2 Memilih $ROCK")
            showLogInfo("MainActivity", "$namePlayer1: $PAPER, Player2: $ROCK")

        } else if (choicePlayer1 == SCISSORS && choicePlayer2 == PAPER) {
            setBgChoice.backgroundChoicePlayer1(SCISSORS)
            setBgChoice.backgroundChoicePlayer2(PAPER)
            activity.binding.imgVs.setImageResource(R.drawable.you_win)
            openDialogResult(activity, namePlayer1, YOU_WIN)
            showToast(activity, "Pemain 2 Memilih $PAPER")
            showLogInfo("MainActivity", "$namePlayer1: $SCISSORS, Player2: $PAPER")
        }

        //PLAYER 2 WINNER
        if (choicePlayer1 == ROCK && choicePlayer2 == PAPER) {
            setBgChoice.backgroundChoicePlayer1(ROCK)
            setBgChoice.backgroundChoicePlayer2(PAPER)
            activity.binding.imgVs.setImageResource(R.drawable.com_win)
            openDialogResult(activity, namePlayer1, YOU_LOSE)
            showToast(activity, "Pemain 2 Memilih $PAPER")
            showLogInfo("MainActivity", "$namePlayer1: $ROCK, Player2: $PAPER")

        } else if (choicePlayer1 == PAPER && choicePlayer2 == SCISSORS) {
            setBgChoice.backgroundChoicePlayer1(PAPER)
            setBgChoice.backgroundChoicePlayer2(SCISSORS)
            activity.binding.imgVs.setImageResource(R.drawable.com_win)
            openDialogResult(activity, namePlayer1, YOU_LOSE)
            showToast(activity, "Pemain 2 Memilih $SCISSORS")
            showLogInfo("MainActivity", "$namePlayer1: $PAPER, Player2: $SCISSORS")

        } else if (choicePlayer1 == SCISSORS && choicePlayer2 == ROCK) {
            setBgChoice.backgroundChoicePlayer1(SCISSORS)
            setBgChoice.backgroundChoicePlayer2(ROCK)
            activity.binding.imgVs.setImageResource(R.drawable.com_win)
            openDialogResult(activity, namePlayer1, YOU_LOSE)
            showToast(activity, "Pemain 2 Memilih $ROCK")
            showLogInfo("MainActivity", "$namePlayer1: $SCISSORS, Player2: $ROCK")
        }
    }
}