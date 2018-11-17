package com.bignerdranch.android.osm.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.memebattle.memebattle.features.main.fragment.rating.domain.model.res.User

@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}