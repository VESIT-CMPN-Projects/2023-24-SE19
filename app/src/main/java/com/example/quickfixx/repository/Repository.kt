package com.example.quickfixx.repository

import com.example.quickfixx.domain.model.Electrician
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.Body

interface Repository {
    suspend fun getAllElectrician(): List<Electrician>?
    suspend fun getElectricianByACService(): List<Electrician>?
    suspend fun getElectricianByTVRepair(): List<Electrician>?
    suspend fun getElectricianByCircuit(): List<Electrician>?
    suspend fun saveElectrician(@Body elecBody: RequestBody)
}