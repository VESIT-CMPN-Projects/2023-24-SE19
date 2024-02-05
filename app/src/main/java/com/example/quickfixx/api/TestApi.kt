package com.example.quickfixx.api

import com.example.quickfixx.model.Post
import retrofit2.http.GET

interface TestApi {
    @GET("1")
    suspend fun getPost(): Post
}