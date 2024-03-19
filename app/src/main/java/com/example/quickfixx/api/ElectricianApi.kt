package com.example.quickfixx.api

import com.example.quickfixx.domain.model.Electrician
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ElectricianApi {
    @GET("electrician")
    suspend fun getAllElectrician(): Response<List<Electrician>>
    @POST("electrician")
    suspend fun saveElectrician(@Body elecBody: RequestBody)
    @GET("electrician/field/acService")
    suspend fun getElectricianByACService(): Response<List<Electrician>>
    @GET("electrician/field/tvRepair")
    suspend fun getElectricianByTVRepair(): Response<List<Electrician>>
    @GET("electrician/field/homeCircuit")
    suspend fun getElectricianByCircuit(): Response<List<Electrician>>
}