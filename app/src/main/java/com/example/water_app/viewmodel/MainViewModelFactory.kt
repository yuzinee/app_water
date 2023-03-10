package com.example.water_app.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.water_app.repository.Repository

class MainViewModelFactory(
    // ViewModel에서 파라미터로 Repository를 받음

    private val repository : Repository
    ) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}