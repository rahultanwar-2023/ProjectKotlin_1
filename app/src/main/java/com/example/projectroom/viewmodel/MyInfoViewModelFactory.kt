package com.example.projectroom.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.projectroom.repository.MyInfoRepository

class MyInfoViewModelFactory(private val repository: MyInfoRepository) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MyInfoViewModel(repository) as T
    }
}