package com.example.quickfixx.domain.model

import android.util.Log
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject

data class Sp(
    val u_id: Long,
    val specz: String,
    val experience: String,
    val address: String,
    val rating: Float,
    val shopName: String
){
    fun convertToJson(): RequestBody {
        val jsonObj = JSONObject()
        jsonObj.put("uid", u_id)
        jsonObj.put("specz" , specz)
        jsonObj.put("experience" ,experience)
        jsonObj.put("address" , address)
        jsonObj.put("rating" ,rating)
        jsonObj.put("shopname" ,shopName)
//        jsonObj.put("image" ,image)
        Log.d("JSON", jsonObj.toString())
//        Log.d("JSON -2", jsonObj.getString("uid"))
        return jsonObj.toString().toRequestBody("application/json".toMediaTypeOrNull())
    }
}
