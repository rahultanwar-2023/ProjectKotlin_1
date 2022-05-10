package com.example.projectroom.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.projectroom.dao.MyInfoDao
import com.example.projectroom.model.MyInfo

@Database(entities = [MyInfo::class], version = 1)
abstract class MyInfoDatabase: RoomDatabase() {

    abstract fun getMyInfoDao(): MyInfoDao

    companion object {
        private var INSTANCE: MyInfoDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = INSTANCE ?: synchronized(LOCK) {
            INSTANCE ?: createDatabase(context).also {
                INSTANCE = it
            }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                MyInfoDatabase::class.java,
                "MyInformation.DB"
            ).build()
    }
}