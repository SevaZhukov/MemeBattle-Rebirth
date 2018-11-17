package com.bignerdranch.android.osm.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.memebattle.memebattle.features.main.fragment.rating.domain.model.res.User

@Dao
interface UserDao {

    @Insert
    fun addUsers(users: List<User>)

    @Query("SELECT * FROM user")
    fun getUsers(): List<User>

    @Query("DELETE FROM user")
    fun deleteAll()

    @Query("SELECT * FROM user LIMIT :pageSize")
    fun loadInit(pageSize: Int): List<User>

    @Query("SELECT * FROM user WHERE id >= :startPosition AND id <= :endPosition")
    fun loadRange(startPosition: Int, endPosition: Int): List<User>
}