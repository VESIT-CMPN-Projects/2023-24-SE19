package com.example.quickfixx.repository

import android.util.Log
import com.example.quickfixx.api.RetrofitInstance
import com.example.quickfixx.api.TestApi
import com.example.quickfixx.model.Post
import javax.inject.Inject

class Repository @Inject constructor(
    private val api: TestApi
) {

    suspend fun getPost(): Post?{
        return api.getPost().body()
    }

}