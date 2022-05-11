package com.example.projectroom.repository

import com.example.projectroom.database.MyInfoDatabase
import com.example.projectroom.model.MyInfo

class MyInfoRepository(private val db: MyInfoDatabase) {

    suspend fun insert(myInfo: MyInfo) = db.getMyInfoDao().myInfoInsert(myInfo)
    suspend fun delete(myInfo: MyInfo) = db.getMyInfoDao().myInfoDelete(myInfo)

    fun getAllInfo() = db.getMyInfoDao().getMyInfo()

}