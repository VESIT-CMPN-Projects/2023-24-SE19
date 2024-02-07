package com.example.quickfixx.repository

import com.example.quickfixx.api.ElectricianApi
import com.example.quickfixx.model.Electrician
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val api: ElectricianApi
) : Repository{

    override suspend fun getAllElectrician(): List<Electrician>?{
        return api.getAllElectrician().body()
    }

}