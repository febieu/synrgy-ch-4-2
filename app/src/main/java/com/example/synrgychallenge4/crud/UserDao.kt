package com.example.synrgychallenge4.crud

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface UserDao {
    @Insert
    fun addUser(user: User)

    @Query("SELECT * FROM user ORDER BY id DESC")
    fun getAllUser(): LiveData<List<User>>

    @Query("SELECT * FROM user WHERE id = :userId")
    fun getUserById(userId: Long): LiveData<User>

    @Update
    suspend fun updateUser(user: User)

    @Delete
    suspend fun deleteUser(user: User)
}