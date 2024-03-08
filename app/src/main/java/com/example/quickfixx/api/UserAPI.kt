package com.example.quickfixx.api

import com.example.quickfixx.domain.model.User
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface UserAPI {
    @GET("user/email")
    suspend fun getByEmail(email: String): User

    @POST("user/save")
    suspend fun saveUser(@Body userBody: RequestBody)
}