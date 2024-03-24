package com.example.quickfixx.presentation.service_provider

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quickfixx.domain.model.Sp
import com.example.quickfixx.repository.CarpenterRepo.CarpeRepo
import com.example.quickfixx.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SpViewModel @Inject constructor(
    val elecRepository: Repository,
    val carpeRepository: CarpeRepo
):ViewModel() {

    fun saveSP(uid: Long, address: String, experience: String, specz: String, rating: Float, shopName: String,domain: String){
        val sp = Sp(uid, specz, experience, address, rating, shopName)
        Log.d("SAVE SP", uid.toString())
        viewModelScope.launch {
            if (domain.toLowerCase()=="electrician"){
                Log.d("SAVED USER", sp.convertToJson().toString())
                elecRepository.saveElectrician(sp.convertToJson())
            }else if (domain == "Carpenter"){
                carpeRepository.createCarpenter(sp.convertToJson())
            }
        }
    }

}