package com.example.quickfixx.ViewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quickfixx.repository.Repository
import com.example.quickfixx.screens.auth.Electrician.ElectricianScreenState
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ElectricianViewModel(
    private val repository: Repository
): ViewModel() {


    private val currUser  = Firebase.auth.currentUser?.email.toString()
    private val _state = MutableStateFlow(ElectricianScreenState())
    val state = _state.asStateFlow()

    init {
        getPost()
    }

    fun getPost() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val postData = async {
                    repository.getPost()
                }.await()

                _state.value = state.value.copy(
                    data = postData
                )
            } catch (e: Exception) {
                Log.e("ElectricianViewModel", "Error fetching post", e)
                _state.value = state.value.copy(
                    errorMsg = e.message
                )
            }
        }
    }

}

//    val myResponse : MutableLiveData<Post> = MutableLiveData()
//
//    fun getPost(){
////        Launch Kotlin coroutine
//        viewModelScope.launch {
//            val response: Post = repository.getPost()
//            myResponse.value= response
//        }
//    }