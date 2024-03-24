package com.example.quickfixx.repository.CarpenterRepo

import com.example.quickfixx.api.CarpenterAPI
import okhttp3.RequestBody
import javax.inject.Inject

class CarpeRepoImpl @Inject constructor(
    val api: CarpenterAPI
): CarpeRepo {
    override suspend fun createCarpenter(carpeBody: RequestBody) {
        api.createCarpenter(carpeBody)
    }
}