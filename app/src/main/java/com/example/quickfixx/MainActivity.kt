package com.example.quickfixx

import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.Manifest
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.quickfixx.ViewModels.ElectricianViewModel
import com.example.quickfixx.presentation.sign_in.GoogleAuthUiClient
import com.example.quickfixx.presentation.sign_in.LoginInScreen
import com.example.quickfixx.presentation.sign_in.SignInViewModel
import com.example.quickfixx.screens.auth.Electrician.ElectricianData
import com.example.quickfixx.screens.auth.ProviderDetails
import com.example.quickfixx.screens.auth.WelcomePageScreen
import com.example.quickfixx.screens.auth.service_provider.UserDetails
import com.example.quickfixx.ui.theme.QuickFixxTheme
import com.google.ai.client.generativeai.GenerativeModel
import com.google.android.gms.auth.api.identity.Identity
import com.google.android.gms.tasks.Task
import com.google.firebase.messaging.FirebaseMessaging
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val googleAuthUiClient by lazy {
        GoogleAuthUiClient(
            context = applicationContext,
            oneTapClient = Identity.getSignInClient(applicationContext)
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            val generativeModel = GenerativeModel(

                modelName = "gemini-pro-vision",

                apiKey = BuildConfig.GOOGLE_API_KEY
            )

        Log.d("FIREBASE MESSAGING", "STARTED")
        // Get the device token
        FirebaseMessaging.getInstance().getToken()
            .addOnCompleteListener { task: Task<String?> ->
                if (task.isSuccessful) {
                    val token = task.result
                    Log.d("FCM Token", token!!)
                    // Send this token to your server
                } else {
                    Log.e("FCM Token", "Error getting token", task.exception)
                }
            }
        requestNotificationPermission()

        setContent {
            QuickFixxTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),

                ) {
                    val navController = rememberNavController()
                    LaunchedEffect(key1 = Unit) {
                        val user = googleAuthUiClient.getSignedInUser()
                        if (user!=null){

                        }
                    }
                    NavHost(navController = navController, startDestination = "welcome") {
                        composable("welcome"){
                            WelcomePageScreen(navController = navController)
                        }

                       composable("electricians"){
//                           val viewModel = ElectricianViewModel(repository = Repository(api = ))
                           val viewModel : ElectricianViewModel= hiltViewModel()
                           ElectricianData(navController = navController, viewModel)
                       }
                        composable("UserDetails"){
                            UserDetails(navController = navController)
                        }
                        composable("profile"){
                            ProviderDetails(navController = navController,
                                onBook = {
                                    Toast.makeText(
                                        applicationContext,
                                        "Booking in process",
                                        Toast.LENGTH_LONG
                                    ).show()

                                })
                        }


                        composable("sign_in") {
                            val viewModel = hiltViewModel<SignInViewModel>()
                            val state by viewModel.state.collectAsStateWithLifecycle()

                            LaunchedEffect(key1 = Unit) {
                                if(googleAuthUiClient.getSignedInUser() != null) {
                                    Log.d("FromLoginPage", "Going to home page")
                                    navController.navigate("home")
                                }
                            }

                            val launcher = rememberLauncherForActivityResult(
                                contract = ActivityResultContracts.StartIntentSenderForResult(),
                                onResult = { result ->
                                    if(result.resultCode == RESULT_OK) {
                                        lifecycleScope.launch {
                                            val signInResult = googleAuthUiClient.signInWithIntent(
                                                intent = result.data ?: return@launch
                                            )
                                            viewModel.onSignInResult(signInResult)
                                        }
                                    }
                                }
                            )

                            LaunchedEffect(key1 = state.isSignInSuccessful) {
                                if(state.isSignInSuccessful) {
                                    Toast.makeText(
                                        applicationContext,
                                        "Sign in successful",
                                        Toast.LENGTH_LONG
                                    ).show()

                                    navController.navigate("home")
                                    viewModel.resetState()
                                }
                            }

                            LoginInScreen(
                                state = state,
                                googleAuthUiClient,
                                onSignInClick = {
                                    lifecycleScope.launch {
                                        val signInIntentSender = googleAuthUiClient.signIn()
                                        launcher.launch(
                                            IntentSenderRequest.Builder(
                                                signInIntentSender ?: return@launch
                                            ).build()
                                        )
                                    }
                                },

                            )
                        }
                        composable("home"){
                            com.example.quickfixx.presentation.profile.HomePage(navController = navController,
                                userData = googleAuthUiClient.getSignedInUser(),
                                onSignOut = {
                                    lifecycleScope.launch {
                                        googleAuthUiClient.signOut()
                                        Toast.makeText(
                                            applicationContext,
                                            "Signed out",
                                            Toast.LENGTH_LONG
                                        ).show()

                                        navController.popBackStack()
                                    }
                                })
                        }

                    }
                }
            }
        }
    }
    private fun requestNotificationPermission() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            val hasPermission = ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.POST_NOTIFICATIONS
            ) == PackageManager.PERMISSION_GRANTED

            if(!hasPermission) {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.POST_NOTIFICATIONS),
                    0
                )
            }
        }
    }
}