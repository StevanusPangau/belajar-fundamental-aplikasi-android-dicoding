package com.learn.dicodingsubmissionakhirfundamentalandroid.data.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.learn.dicodingsubmissionakhirfundamentalandroid.data.local.entity.UsersEntity

@Database(entities = [UsersEntity::class], version = 1)
abstract class UsersDatabase : RoomDatabase() {
    abstract fun userDao(): UsersDao

    companion object {
        @Volatile
        private var INSTANCE: UsersDatabase? = null

        @JvmStatic
        fun getDatabase(context: Context): UsersDatabase {
            if (INSTANCE == null) {
                synchronized(UsersDatabase::class.java) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        UsersDatabase::class.java, "users_database"
                    ).build()
                }
            }
            return INSTANCE as UsersDatabase
        }
    }
}