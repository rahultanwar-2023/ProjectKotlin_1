package com.example.projectroom.viewmodel

import androidx.lifecycle.ViewModel
import com.example.projectroom.model.MyInfo
import com.example.projectroom.repository.MyInfoRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MyInfoViewModel(private val repository: MyInfoRepository): ViewModel()  {

    fun insert(myInfo: MyInfo) = GlobalScope.launch {
        repository.insert(myInfo)
    }

    fun delete(myInfo: MyInfo) = GlobalScope.launch {
        repository.delete(myInfo)
    }

    fun getAllMyInfo() = repository.getAllInfo()

}