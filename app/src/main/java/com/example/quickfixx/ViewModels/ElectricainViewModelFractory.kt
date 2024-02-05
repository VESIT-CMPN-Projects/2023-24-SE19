package com.example.quickfixx.ViewModels

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.quickfixx.repository.Repository

class ElectricainViewModelFractory(
    private val repository: Repository
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ElectricianViewModel(repository) as T
    }
}