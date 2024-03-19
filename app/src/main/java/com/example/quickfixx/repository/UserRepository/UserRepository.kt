package com.example.quickfixx.repository.UserRepository

import com.example.quickfixx.domain.model.User
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.Path

interface UserRepository {
    suspend fun getByEmail(email: String): User?
    suspend fun saveUser(@Body userBody: RequestBody)
    suspend fun updateUser(@Path("id") userId: String, @Body userBody: RequestBody)
}