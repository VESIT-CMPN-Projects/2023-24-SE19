package com.example.quickfixx.api

import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.POST

interface CarpenterAPI {
    @POST
    suspend fun createCarpenter(@Body carpenterBody: RequestBody)
}