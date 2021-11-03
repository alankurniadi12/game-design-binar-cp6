package com.binar.gamedesignbinarcp6.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.binar.gamedesignbinarcp6.R
import com.binar.gamedesignbinarcp6.database.Users
import com.binar.gamedesignbinarcp6.database.UsersRoomDatabase
import com.binar.gamedesignbinarcp6.databinding.ActivityListUserBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class ListUserActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListUserBinding
    private lateinit var adapter: UserAdapter
    var mDB: UsersRoomDatabase? = null
    private val TAG = ListUserActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.i(TAG, "onCreate:.....")

        mDB = UsersRoomDatabase.builDataBase(this)
        adapter = UserAdapter()
        GlobalScope.async {
            val listUser = mDB?.UsersDao()?.getAllUsers()
            Log.i(TAG, "Data db = $listUser ")
            runOnUiThread {
                adapter.setData(listUser as ArrayList<Users>)
            }
        }

        binding.rvUser.layoutManager = LinearLayoutManager(this)
        binding.rvUser.adapter = adapter

    }
}