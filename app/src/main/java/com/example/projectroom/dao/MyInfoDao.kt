package com.example.projectroom.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.projectroom.model.MyInfo

@Dao
interface MyInfoDao {
    @Insert
    fun myInfoInsert(myInfo: MyInfo)
    @Delete
    fun myInfoDelete(myInfo: MyInfo)
    @Query("SELECT * FROM myinfo_table")
    fun getMyInfo(): LiveData<List<MyInfo>>
}