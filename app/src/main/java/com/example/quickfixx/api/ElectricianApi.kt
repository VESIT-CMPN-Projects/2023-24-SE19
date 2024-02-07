package com.example.quickfixx.api

import com.example.quickfixx.model.Post
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface TestApi {
    @GET("electrician/1")
    suspend fun getPost(): Response<Post>
}