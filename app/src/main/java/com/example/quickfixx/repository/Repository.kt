package com.example.quickfixx.repository

import com.example.quickfixx.model.Electrician

interface Repository {
    suspend fun getAllElectrician(): List<Electrician>?
}