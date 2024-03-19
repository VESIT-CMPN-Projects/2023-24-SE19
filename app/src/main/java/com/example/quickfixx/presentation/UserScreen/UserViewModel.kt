package com.example.quickfixx.presentation.UserScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quickfixx.domain.model.User
import com.example.quickfixx.repository.UserRepository.UserRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val userRepo : UserRepositoryImpl
): ViewModel() {
    private val _state = MutableStateFlow(UserScreenState())
    val state = _state.asStateFlow()

    fun updateUser(userId: String, user: User){
        viewModelScope.launch {
            userRepo.updateUser(userId, user.convertToJson())
        }
    }
}