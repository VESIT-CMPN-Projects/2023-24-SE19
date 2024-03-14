package com.example.quickfixx.screens.auth.Electrician

import com.example.quickfixx.domain.model.Electrician

data class ElectricianScreenState(
    val data: List<Electrician>? = null,
    val acservice: List<Electrician>? = null,
    val tvservice: List<Electrician>? = null,
    val circuitService: List<Electrician>? = null,
    val errorMsg: String?= null
)
