package com.example.quickfixx.repository.UserRepository

import com.example.quickfixx.api.UserAPI
import com.example.quickfixx.domain.model.User
import okhttp3.RequestBody
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val api: UserAPI
): UserRepository {
    override suspend fun getByEmail(email: String): User? {
        return api.getByEmail(email)
    }

    override suspend fun saveUser(userBody: RequestBody) {
        api.saveUser(userBody)
    }

}