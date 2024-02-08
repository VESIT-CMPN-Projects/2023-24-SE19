package com.example.quickfixx.screens.auth.Electrician

import com.example.quickfixx.model.Electrician

data class ElectricianScreenState(
    val data: List<Electrician>? = null,
    val errorMsg: String?= null
)
