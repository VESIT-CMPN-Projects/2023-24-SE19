package com.example.quickfixx.presentation.sign_in
import androidx.lifecycle.ViewModel
import com.example.quickfixx.domain.model.User

import com.example.quickfixx.repository.UserRepository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import retrofit2.HttpException
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    val repo: UserRepository
): ViewModel() {

    private val _state = MutableStateFlow(SignInState())
    val state = _state.asStateFlow()

    fun onSignInResult(result: SignInResult) {
        _state.update { it.copy(
            isSignInSuccessful = result.data != null,
            signInError = result.errorMessage
        ) }
    }

    suspend fun getUserByEmail(email: String): User? {
        return try {
            repo.getByEmail(email)
        } catch (e: HttpException) {
            if (e.code() == 500) {
                null // User not found
            } else {
                throw e // Re-throw the exception for other HTTP errors
            }
        }
    }


    //    val name: String,
//    val email: String,
//    val password : String,
//    val contact : String,
//    val role: String,
//    val image: String
    fun saveUser(name: String, email: String, password:String, role:String, contact : String, image: String){
        val userBody = User(name, email, password, contact, role, image)
    }

    fun resetState() {
        _state.update { SignInState() }
    }
}