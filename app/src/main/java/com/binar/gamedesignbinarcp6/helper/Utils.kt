package com.binar.gamedesignbinarcp6.helper

import android.content.Context
import android.os.Build
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.binar.gamedesignbinarcp6.R
import com.binar.gamedesignbinarcp6.ui.DialogFragment

object Utils {
    const val SCISSORS = "GUNTING"
    const val ROCK = "BATU"
    const val PAPER = "KERTAS"
    const val YOU_WIN = "MENANG!"
    const val YOU_LOSE = "KALAH!"
    const val DRAW = "SERI!"

    fun openDialogResult(activity: AppCompatActivity, name: String, result: String) {
        val dialogFragment = DialogFragment(name, result)
        dialogFragment.show(activity.supportFragmentManager, null)
    }

    fun showToast(context: Context, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    fun showLogInfo(TAG: String, message: String) {
        Log.i(TAG, message)
    }

    fun View.show() {
        visibility = View.VISIBLE
    }

    fun View.hide() {
        visibility = View.INVISIBLE
    }

    fun View.resetBgChoice() {
        setBackgroundColor(0)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun View.colorBgChoice() {
        setBackgroundColor(resources.getColor(R.color.bg_choice, null))
    }
}