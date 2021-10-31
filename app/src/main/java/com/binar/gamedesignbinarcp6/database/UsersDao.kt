package com.binar.gamedesignbinarcp6.database

import androidx.room.*

@Dao
interface UsersDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(users: Users)

    @Update
    fun update(users: Users)

    @Delete
    fun delete(users: Users)

    @Query("SELECT * FROM users")
    fun getAllUsers():List<Users>

    @Query("SELECT * FROM users WHERE :id = id")
    fun getUsersById(id: Int): Users

    @Query("SELECT * FROM users WHERE :name = name")
    fun getUsersByName(name: String)

    @Query("SELECT * FROM users WHERE :number = number")
    fun getUsersByNumber(number: String)
}