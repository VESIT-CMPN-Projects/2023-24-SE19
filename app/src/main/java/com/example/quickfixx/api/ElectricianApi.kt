package com.example.quickfixx.api

import com.example.quickfixx.model.Electrician
import retrofit2.Response
import retrofit2.http.GET

interface ElectricianApi {
    @GET("electrician")
    suspend fun getAllElectrician(): Response<List<Electrician>>
}