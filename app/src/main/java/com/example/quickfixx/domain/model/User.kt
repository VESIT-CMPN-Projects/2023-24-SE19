package com.example.quickfixx.domain.model

import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject

data class User(
    val name: String,
    val email: String,
    val password : String,
    val contact : String,
    val role: String,
    val image: String
){
    fun convertToJson(): RequestBody {
        val jsonObj = JSONObject()
        jsonObj.put("name", name)
        jsonObj.put("email" , email)
        jsonObj.put("password" ,password)
        jsonObj.put("contact" , contact)
        jsonObj.put("role" ,role)
        jsonObj.put("image" ,image)

        return jsonObj.toString().toRequestBody("application/json".toMediaTypeOrNull())
    }
}
