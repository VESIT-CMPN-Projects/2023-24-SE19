package com.example.quickfixx.api

import com.example.quickfixx.domain.model.User
import okhttp3.RequestBody
import okhttp3.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface UserAPI {
    @GET("users/email")
    suspend fun getByEmail(@Query("email") email: String): User?

    @POST("users/save")
    suspend fun saveUser(@Body userBody: RequestBody)
}