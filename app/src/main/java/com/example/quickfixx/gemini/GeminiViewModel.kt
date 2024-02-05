package com.example.quickfixx.gemini

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import java.io.BufferedReader

class GeminiViewModel: ViewModel (){
    private val state = MutableStateFlow("")

    fun updateResponse(response: String){
        state.update {
            response
        }
    }
}