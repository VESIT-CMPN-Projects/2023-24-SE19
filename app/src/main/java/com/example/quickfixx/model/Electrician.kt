package com.example.quickfixx.model

data class Electrician(
    val name : String,
    val id: Int,
    val contact: String,
    val location: String,
    val experience: String,
    val qualitfication: Array<String>,
    val rating: Float
)
///"id": 4,
//"name": "Nigahm R",
//"contact": 9998599985,
//"location": "Mulund",
//"address": "Mulund, Central Line, Home",
//"experience": "5 years",
//"qualification": ["Gove