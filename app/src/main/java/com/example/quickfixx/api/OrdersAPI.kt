package com.example.quickfixx.api

import retrofit2.http.POST

interface OrdersAPI {
    @POST("send")
    suspend fun sendOrder()
}