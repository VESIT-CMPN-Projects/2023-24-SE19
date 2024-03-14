package com.example.quickfixx.api

import com.example.quickfixx.domain.model.Electrician
import retrofit2.Response
import retrofit2.http.GET

interface ElectricianApi {
    @GET("electrician")
    suspend fun getAllElectrician(): Response<List<Electrician>>
    @GET("electrician/field/acService")
    suspend fun getElectricianByACService(): Response<List<Electrician>>
    @GET("electrician/field/tvRepair")
    suspend fun getElectricianByTVRepair(): Response<List<Electrician>>
    @GET("electrician/field/homeCircuit")
    suspend fun getElectricianByCircuit(): Response<List<Electrician>>
}