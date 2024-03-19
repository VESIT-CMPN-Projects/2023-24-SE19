package com.example.quickfixx.presentation.sign_in

import com.example.quickfixx.domain.model.User

data class SignInState(
    val isSignInSuccessful: Boolean = false,
    val signInError: String? = null,
    var user: User? = null,
    var userData: UserData? = null
)