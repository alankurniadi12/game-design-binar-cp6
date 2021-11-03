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
import com.binar.gamedesignbinarcp6.helper.Utils.showToast
import com.binar.gamedesignbinarcp6.ui.MainActivity

open class ResultGameVsCom(private val activity: MainActivity) {

    private val setBgChoice = SetBackgroundChoice(activity)

    @RequiresApi(Build.VERSION_CODES.M)
    open fun playerChoiceGunting(name: String, player: String, com: String) {
        if (player == SCISSORS && com == activity.comList[0]) {
            setBgChoice.backgroundChoicePlayer1(SCISSORS)
            setBgChoice.backgroundChoiceCom(SCISSORS)
            activity.binding.imgVs.setImageResource(R.drawable.draw)
            openDialogResult(activity, name, DRAW)
            showToast(activity, "$name Memilih $SCISSORS\nCOM Memilih $SCISSORS")

        } else if (player == SCISSORS && com == activity.comList[1]) {
            setBgChoice.backgroundChoicePlayer1(SCISSORS)
            setBgChoice.backgroundChoiceCom(ROCK)
            activity.binding.imgVs.setImageResource(R.drawable.com_win)
            openDialogResult(activity, name, YOU_LOSE)
            showToast(activity, "$name Memilih $SCISSORS\n COM Memilih $ROCK")

        } else if (player == SCISSORS && com == activity.comList[2]) {
            setBgChoice.backgroundChoicePlayer1(SCISSORS)
            setBgChoice.backgroundChoiceCom(PAPER)
            activity.binding.imgVs.setImageResource(R.drawable.you_win)
            openDialogResult(activity, name, YOU_WIN)
            showToast(activity, "$name Memilih $SCISSORS\n COM Memilih $PAPER")
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    open fun playerChoiceBatu(name: String, player: String, com: String) {
        if (player == ROCK && com == activity.comList[0]) {
            setBgChoice.backgroundChoicePlayer1(ROCK)
            setBgChoice.backgroundChoiceCom(SCISSORS)
            activity.binding.imgVs.setImageResource(R.drawable.you_win)
            openDialogResult(activity, name, YOU_WIN)
            showToast(activity, "$name Memilih $ROCK\n COM Memilih $SCISSORS")

        } else if (player == ROCK && com == activity.comList[1]) {
            setBgChoice.backgroundChoicePlayer1(ROCK)
            setBgChoice.backgroundChoiceCom(ROCK)
            activity.binding.imgVs.setImageResource(R.drawable.draw)
            openDialogResult(activity, name, DRAW)
            showToast(activity, "$name Memilih $ROCK\n COM Memilih $ROCK")

        } else if (player == ROCK && com == activity.comList[2]) {
            setBgChoice.backgroundChoicePlayer1(ROCK)
            setBgChoice.backgroundChoiceCom(PAPER)
            activity.binding.imgVs.setImageResource(R.drawable.com_win)
            openDialogResult(activity, name, YOU_LOSE)
            showToast(activity, "$name Memilih $ROCK\n COM Memilih $PAPER")
        }
    }


    @RequiresApi(Build.VERSION_CODES.M)
    open fun playerChoiceKertas(name: String, player: String, com: String) {
        if (player == PAPER && com == activity.comList[0]) {
            setBgChoice.backgroundChoicePlayer1(PAPER)
            setBgChoice.backgroundChoiceCom(SCISSORS)
            activity.binding.imgVs.setImageResource(R.drawable.com_win)
            openDialogResult(activity, name, YOU_LOSE)
            showToast(activity, "$name Memilih $PAPER\n COM Memilih $SCISSORS")

        } else if (player == PAPER && com == activity.comList[1]) {
            setBgChoice.backgroundChoicePlayer1(PAPER)
            setBgChoice.backgroundChoiceCom(ROCK)
            activity.binding.imgVs.setImageResource(R.drawable.you_win)
            openDialogResult(activity, name, YOU_WIN)
            showToast(activity, "$name Memilih $PAPER\n COM Memilih $ROCK")

        } else if (player == PAPER && com == activity.comList[2]) {
            setBgChoice.backgroundChoicePlayer1(PAPER)
            setBgChoice.backgroundChoiceCom(PAPER)
            activity.binding.imgVs.setImageResource(R.drawable.draw)
            openDialogResult(activity, name, DRAW)
            showToast(activity, "$name Memilih $PAPER\n COM Memilih $PAPER")
        }
    }
}