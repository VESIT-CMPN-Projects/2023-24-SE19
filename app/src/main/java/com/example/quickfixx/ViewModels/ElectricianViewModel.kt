package com.example.quickfixx.ViewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quickfixx.repository.Repository
import com.example.quickfixx.screens.auth.Electrician.ElectricianScreenState
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ElectricianViewModel @Inject constructor(
    private val repository: Repository
): ViewModel() {


    private val currUser  = Firebase.auth.currentUser?.email.toString()
    private val _state = MutableStateFlow(ElectricianScreenState())
    val state = _state.asStateFlow()

    init {
        getAllElectrician()
    }

    fun getAllElectrician() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val electricians = async {
                    repository.getAllElectrician()
                }.await()

                _state.value = state.value.copy(
                    data = electricians
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