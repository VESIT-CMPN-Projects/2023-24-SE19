package com.example.quickfixx.screens.auth

// GoogleSignInHelper.kt

import android.app.Activity
import android.content.Intent
import com.example.quickfixx.R
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider

class GoogleSignInHelper(private val activity: Activity) {

    private val firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()

    private val googleSignInClient = GoogleSignIn.getClient(
        activity,
        GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(activity.getString(R.string.web_client_id))
            .requestEmail()
            .build()
    )

    fun signInWithGoogle() {
        val signInIntent: Intent = googleSignInClient.signInIntent
        activity.startActivityForResult(signInIntent, RC_SIGN_IN)
    }

    fun handleSignInResult(data: Intent?): Task<AuthResult> {
        val task = GoogleSignIn.getSignedInAccountFromIntent(data)
        val account = task.getResult(ApiException::class.java)
        return getGoogleAuthCredential(account?.idToken!!)
    }

//    private fun startHomePageActivity() {
//        val intent = Intent(activity, HomePage(navController = n))
//        activity.startActivity(intent)
//        // Optionally, you can finish the current activity to prevent going back to the login screen
//        activity.finish()
//    }
    private fun getGoogleAuthCredential(idToken: String): Task<AuthResult> {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        return firebaseAuth.signInWithCredential(credential)
    }

    companion object {
        const val RC_SIGN_IN = 9001
    }
}
