package com.example.quickfixx.repository.CarpenterRepo

import okhttp3.RequestBody
import retrofit2.http.Body

interface CarpeRepo {
    suspend fun createCarpenter(@Body carpeBody: RequestBody)
}