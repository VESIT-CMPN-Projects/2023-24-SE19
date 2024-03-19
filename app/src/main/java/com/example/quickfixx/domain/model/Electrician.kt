package com.example.quickfixx.domain.model

import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject

data class Electrician(
    val name : String,
    val id: Int,
    val contact: String,
    val location: String,
    val experience: String,
    val qualitfication: Array<String>,
    val rating: Float
){
    fun convertToJson(): RequestBody? {
//        val jsonObj = JSONObject()
//        jsonObj.put("name", name)
//        jsonObj.put("email" , email)
//        jsonObj.put("password" ,password)
//        jsonObj.put("contact" , contact)
//        jsonObj.put("role" ,role)
//        jsonObj.put("image" ,image)

//        return jsonObj.toString().toRequestBody("application/json".toMediaTypeOrNull())
        return null
    }
}
///"id": 4,
//"name": "Nigahm R",
//"contact": 9998599985,
//"location": "Mulund",
//"address": "Mulund, Central Line, Home",
//"experience": "5 years",
//"qualification": ["Gove