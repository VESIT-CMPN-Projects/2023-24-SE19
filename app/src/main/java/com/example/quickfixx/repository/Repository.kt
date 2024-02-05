package com.example.quickfixx.repository

import android.util.Log
import com.example.quickfixx.api.RetrofitInstance
import com.example.quickfixx.model.Post

class Repository {

//    suspend fun getPost(): Post {
        //        return RetrofitInstance.api.getPost()
//    }
        suspend fun getPost(): Post {
            try {
                val post = RetrofitInstance.api.getPost()
                Log.d("Repository", post.title)
                return  post
            } catch (e: Exception) {
                // Log the exception
                e.message?.let { Log.e("Repository", it) }
                throw e // rethrow the exception to propagate it
            }
        }

}